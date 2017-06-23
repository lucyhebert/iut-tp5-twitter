<template>
  <div class="feed">
    <div v-if="loading === true">
      Chargement des tweets en cours…
    </div>
    <div v-else>
      <ul>
        <li v-for="tweet in tweets">
          <tweet :tweet="tweet"/>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

  import Tweet from './Tweet'

  export default {
    name: 'feed',
    components: {Tweet},
    props: ['tweets', 'loading']
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
