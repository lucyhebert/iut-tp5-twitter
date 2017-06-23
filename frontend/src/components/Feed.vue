<template>
  <div class="feed">
    <div v-if="loading === true">
      Chargement des tweets en cours…
    </div>
    <div v-else>
      <ul>
        <li class="tweet" v-for="tweet in tweets">
          <tweet :tweet="tweet" @retweeted="retweet" :utilisateurCourant="utilisateurCourant" />
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
    props: ['tweets', 'loading', 'utilisateurCourant'],
    methods: {
      retweet: function (id) {
        this.$emit('retweeted', id)
      },
      onChange: function (utilisateur) {
        this.$emit('userChanged', utilisateur)
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

  li.tweet:first-child {
   border-top-width: 1px;
  }

  li.tweet {
   border-style: solid;
   border-width: 0 1px 1px 1px;
   border-color: gray;
   width: 500px;
   margin: auto;
  }
</style>
