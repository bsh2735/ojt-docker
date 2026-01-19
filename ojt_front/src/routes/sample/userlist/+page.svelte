<script>
  import { onMount } from 'svelte';

  let users = [];

  let keyword = '';
  let type = 'name';
  let startDate = '';
  let endDate = '';

  async function loadList() {
    const res = await fetch('http://localhost:8081/api/sample/list');
    users = await res.json();
  }
  async function search() {
    const params = new URLSearchParams({
      keyword,
      type,
      startDate,
      endDate
    });

    const res = await fetch(
      `http://localhost:8081/api/sample/search?${params.toString()}`
    );
    users = await res.json();
  }
  function highlight(text) {
    if (!keyword) return text;
    const regex = new RegExp(`(${keyword})`, 'gi');
    return text.replace(regex, '<mark>$1</mark>');
  }
  onMount(loadList);
</script>


<h1>User Search</h1>

<div>
  <select bind:value={type}>
    <option value="name">Name</option>
    <option value="email">Email</option>
  </select>

  <input placeholder="Keyword" bind:value={keyword} />
  <input type="date" bind:value={startDate} />
  <input type="date" bind:value={endDate} />

  <button on:click={search}>Search</button>
  <button on:click={loadList}>Reset</button>
</div>

<hr />

{#if users.length === 0}
  <p>No result</p>
{:else}
  <ul>
    {#each users as user}
      <li>
        <strong>{@html highlight(user.name)}</strong>
        — {@html highlight(user.email)}
      </li>
    {/each}
  </ul>
{/if}


<!--

<script>
  let page = 1;
</script>

<div class="pagination">
  <button on:click={() => page&#45;&#45;} disabled={page === 1}>
    Prev
  </button>

  <span>Page {page}</span>

  <button on:click={() => page++}>
    Next
  </button>
</div>
-->
