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
          <span v-if="canRetweet()">
            <a @click="retweet(tweet.id)">
              <icon name="retweet"/>
              <span>
                {{tweet.retweeters.length}}
              </span>
            </a>
          </span>
          <span v-else>
            <icon name="retweet"/>
            <span>
              {{tweet.retweeters.length}}
            </span>
          </span>
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
    props: ['tweet', 'utilisateurCourant'],
    components: {Icon},
    methods: {
      moment: function (date) {
        return moment(date)
      },
      retweet: function (id) {
        var data = new FormData()
        data.append('utilisateur', this.utilisateurCourant)
        data.append('tweet', id)
        this.$http.post('http://localhost:8080/retweet', data, {responseType: 'text'}).then(response => {
          this.$emit('retweeted', id)
        })
      },
      canRetweet: function () {
        if (this.utilisateurCourant === this.tweet.auteur.handle || !this.utilisateurCourant) {
          return false
        }
        for (var i = 0; i < this.tweet.retweeters.length; i++) {
          if (this.utilisateurCourant === this.tweet.retweeters[i].handle) {
            return false
          }
        }
        return true
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
