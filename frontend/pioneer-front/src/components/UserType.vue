<template>
  <div>
    <div class="slogan-container">
      <p class="slogan">ПРЕДОСТАВЛЕНИЕ<br>УСЛУГ<br>ТРАНСПОРТНЫМ<br>СРЕДСТВАМ</p>
    </div>
    <div class="user-types-buttons">
      <router-link to="/userlogin" class="button-link">
        <button class="user-option-button">Владельцам транспортных средств</button>
      </router-link>
      <router-link to="/connectionform">
        <button class="user-option-button">Организациям - партнёрам</button>
      </router-link>
      <router-link to="/formlist">
        <button class="user-option-button">Администрирование</button>
      </router-link>
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      responseData: ""
    };
  }
};
</script>

<style>
</style>
