<template>
  <div class="timeline">
    <ul>
      <li v-for="tweet in tweets">
        <tweet :tweet="tweet"/>
      </li>
    </ul>
  </div>
</template>

<script>

  import Tweet from './Tweet'
  import Vue from 'vue'
  import Resource from 'vue-resource'
  Vue.use(Resource)

  // var tweet1 = {auteur: 'Lulu', contenu: 'Pouet-pouet'}
  // var tweet2 = {auteur: 'Nico', contenu: 'Prout'}
  // var tweet3 = {auteur: 'Guigui', contenu: 'Prout-pouet'}

  export default {
    name: 'timeline',
    data () {
      return {
        tweets: []
      }
    },
    components: {Tweet},
    methods: {
      fetchTweets: function () {
        this.$http.get('http://localhost:8080/list').then(response => {
          // get body data
          this.tweets = response.body
          console.log(response.body)
        }, response => {
          // error callback
        })
      }
    },
    created () {
      this.fetchTweets()
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
