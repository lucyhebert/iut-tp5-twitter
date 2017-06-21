<template>
  <div class="timeline">
    <ul>
      <li v-for="tweet in tweets">{{tweet}}</li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: 'timeline',
    data () {
      return {
        tweets: ['tweet 1', 'tweet 2', 'tweet 3']
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
