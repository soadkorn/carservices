<script>
export default {
  props: {
    UserName: {
      type: String,
      required: true
    }
  },
  computed: {
        isHomePage() {
            return this.$route.path === '/';
        }
    },
    methods: {
        goBack() {
            this.$router.go(-1); // Это переходит назад на одну страницу в истории браузера
        }
    }
}
</script>

<style>
    @import '../assets/main.css';
</style>

<template>
    <div class="page-header">
        <RouterLink to = "/">
        <img class="logo" src="../pioneer.png">
        </RouterLink>
    </div>
    <div class="navigation-bar">
        <div class="left-section">
            <img class="go-back-button" @click="goBack" src="../assets/icons8-go-back-60.png" v-if="!isHomePage">
        </div>
        <div class="right-section">
            <p class="username">{{ UserName }}</p>
            <img class="user-picture" src="../assets/User.png">
        </div>
    </div>
</template>