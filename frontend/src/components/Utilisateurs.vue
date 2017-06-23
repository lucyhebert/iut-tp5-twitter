<template>
  <div class="utilisateur">
    <select @change="onChange($event.target.value)">
     <option value="">Choisissez un utilisateur ...</option>
     <option v-for="utilisateur in utilisateurs" :value="utilisateur.handle">
       {{ utilisateur.prenom }} {{ utilisateur.nom }}
     </option>
    </select>
  </div>
</template>

<script>

  export default {
    name: 'utilisateur',
    props: [ 'utilisateurs', 'utilisateurCourant' ],
    methods: {
      onChange: function (utilisateur) {
        this.utilisateurCourant = utilisateur
        this.$emit('userChanged', this.utilisateurCourant)
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
