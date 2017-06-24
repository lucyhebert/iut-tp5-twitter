<template>
  <div class="postTweet">
    <textarea v-model="textTweet" placeholder="Nouveau tweet"></textarea>
    <br>
    <button v-on:click="postNewTweet(textTweet)">Tweet</button>
  </div>
</template>

<script>

  export default {
    name: 'postTweet',
    data () {
      return {
        newTweet: ''
      }
    },
    props: ['utilisateurCourant', 'textTweet'],
    methods: {
      postNewTweet: function (textTweet) {
        this.newTweet = textTweet
        this.$emit('newTweet', this.newTweet)
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
