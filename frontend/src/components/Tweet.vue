<template>
  <div class="tweet">
    <div>
      <strong>
        {{tweet.auteur.prenom}} {{tweet.auteur.nom}}
      </strong>
      <span class="handle">
        {{tweet.auteur.handle}} - {{moment(tweet.date).fromNow()}}
      </span>
    </div>
    <div>
      {{tweet.contenu}}
    </div>
    <div>
      <ul>
        <li class="button">
          <icon name="reply"/>
        </li>
        <li class="button">
          <a @click="retweet(tweet.id)">
            <icon name="retweet"/>
            <span>{{tweet.retweeters.length}}</span>
          </a>
        </li>
        <li class="button">
          <icon name="heart"/>
        </li>
        <li class="button">
          <icon name="envelope"/>
        </li>
      </ul>
    </div>

  </div>
</template>

<script>

  import 'vue-awesome/icons'
  import Icon from 'vue-awesome/components/Icon'
  import moment from 'moment'

  export default {
    created () {
      moment.locale('fr')
    },
    name: 'tweet',
    props: ['tweet'],
    components: {Icon},
    methods: {
      moment: function (date) {
        return moment(date)
      },
      retweet: function (id) {
        var data = new FormData()
        data.append('utilisateur', 'Lulu')
        data.append('tweet', id)
        this.$http.post('http://localhost:8080/retweet', data, {responseType: 'text'}).then(response => {
          this.$emit('retweeted', id)
          console.log('reponse')
        })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  li.button {
   display: inline-block;
  }

  a {
   color: #42b983;
  }

  span.handle {
   color: gray;
  }
</style>
