<script>
  let name = '';
  let email = '';
  let message = '';

  async function createUser() {
    if (!name || !email) {
      message = 'Name and Email are required.';
      return;
    }

    const res = await fetch('http://localhost:8081/api/sample', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name, email })
    });

    if (res.ok) {
      message = 'User created successfully.';
      name = '';
      email = '';
    } else {
      message = 'Failed to create user.';
    }
  }
</script>

<h1>Create User</h1>

<input placeholder="Name" bind:value={name} />
<input placeholder="Email" bind:value={email} />
<button on:click={createUser}>Create</button>

<p>{message}</p>
