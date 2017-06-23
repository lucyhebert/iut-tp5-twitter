<template>
  <div id="app">
    <img src="https://avatars2.githubusercontent.com/u/23234906?v=3&u=d5da668ead24dd70d642cdf2db4e9ab5057cb415&s=400">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
