<template>
  <div class="timeline">
    <ul>
      <li v-for="tweet in tweets">{{tweet.auteur}} : {{tweet.contenu}}</li>
    </ul>
  </div>
</template>

<script>
  var tweet1 = {auteur: 'Lulu', contenu: 'Pouet-pouet'}
  var tweet2 = {auteur: 'Nico', contenu: 'Prout'}
  var tweet3 = {auteur: 'Guigui', contenu: 'Prout-pouet'}

  export default {
    name: 'timeline',
    data () {
      return {
        tweets: [tweet1, tweet2, tweet3]
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
