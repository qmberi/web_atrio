<template>
  <div id="app">
    <header>
      <h1>Application Vue 3 - Gestion des Employés</h1>
    </header>
    <main>
      <router-view />
    </main>
    <footer>
      <p>&copy; 2025 - Gestion des Employés</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
