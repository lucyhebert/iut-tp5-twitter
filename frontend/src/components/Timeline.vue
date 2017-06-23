<template>
  <div class="timeline">
    <div> {{ (this.utilisateurCourant ? "Utilisateur connecté : " + this.utilisateurCourant : "Identifiez-vous :") }} </div>
    <utilisateurs :utilisateurs="utilisateurs" @userChanged="onChange"/>
    <feed :tweets="tweets" :loading="loading" :utilisateurCourant="utilisateurCourant" @retweeted="retweet" />
  </div>
</template>

<script>
  import Utilisateurs from './Utilisateurs'
  import Feed from './Feed'
  import Vue from 'vue'
  import Resource from 'vue-resource'
  Vue.use(Resource)

  export default {
    created () {
      this.fetchTweets()
      this.fetchUtilisateurs()
    },
    name: 'timeline',
    props: [ 'utilisateurCourant' ],
    data () {
      return {
        tweets: [],
        loading: true,
        utilisateurs: []
      }
    },
    components: {Feed, Utilisateurs},
    methods: {
      fetchTweets: function () {
        this.$http.get('http://localhost:8080/list').then(response => {
          this.tweets = response.body
          this.loading = false
        }, response => {
          // error callback
        })
      },
      fetchUtilisateurs: function () {
        this.$http.get('http://localhost:8080/utilisateurs').then(response => {
          this.utilisateurs = response.body
          console.log(this.utilisateurs)
        }, response => {
          // error callback
        })
      },
      retweet: function (id) {
        var data = new FormData()
        data.append('utilisateur', this.utilisateurCourant)
        for (var i = 0; i < this.tweets.length; i++) {
          if (this.tweets[i].id === id) {
            this.tweets[i].retweeters.push(data)
          }
        }
      },
      onChange: function (utilisateur) {
        this.utilisateurCourant = utilisateur
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
</style>
