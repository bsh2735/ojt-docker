<script>
  import { onMount } from 'svelte';
  import { page } from '$app/stores';

  let name = '';
  let email = '';
  let message = '';

  $: userId = $page.params.id;

  onMount(async () => {
    const res = await fetch(
      `http://localhost:8081/api/sample/${userId}`
    );
    const user = await res.json();
    name = user.name;
    email = user.email;
  });

  async function submitForm() {
    if (!name || !email) {
      message = 'Name and Email are required.';
      return;
    }

    const res = await fetch(
      'http://localhost:8081/api/sample/email',
      {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email })
      }
    );

    message = res.ok
      ? 'User updated successfully.'
      : 'Update failed.';
  }
</script>

<h1>Edit User</h1>

<input bind:value={name} />
<input bind:value={email} />
<button on:click={submitForm}>Update</button>

<p>{message}</p>
