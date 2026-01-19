<script>
  import { onMount } from 'svelte';
  import { page } from '$app/stores';

  let user = null;
  $: userId = $page.params.id;

  onMount(async () => {
    const res = await fetch(
      `http://localhost:8081/api/sample/${userId}`
    );
    user = await res.json();
  });

  function goEdit() {
    window.location.href = `/sample/${userId}/edit`;
  }

  async function deleteUser() {
    const confirmDelete = confirm('Are you sure you want to delete this user?');
    if (!confirmDelete) return;
    const res = await fetch(
      `http://localhost:8081/api/sample/${userId}`,
      { method: 'DELETE' }
    );
    if (res.ok) {
      alert('User deleted successfully.');
      window.location.href = '/sample';
    } else {
      alert('Failed to delete user.');
    }
  }
</script>

{#if user}
  <h1>User Detail</h1>
  <p><strong>Name:</strong> {user.name}</p>
  <p><strong>Email:</strong> {user.email}</p>

  <button on:click={goEdit}>Edit</button>
  <button on:click={deleteUser}>Delete</button>
{:else}
  <p>Loading...</p>
{/if}
