<template>
  <div class="tweet">
     {{tweet.auteur.nom}} {{tweet.auteur.prenom}} ({{tweet.auteur.handle}}) : {{tweet.contenu}}
  </div>
</template>

<script>

  export default {
    name: 'tweet',
    props: ['tweet']
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
