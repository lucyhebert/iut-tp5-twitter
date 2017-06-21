<template>
  <div class="tweet">
    {{tweet.auteur}} : {{tweet.contenu}}
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
