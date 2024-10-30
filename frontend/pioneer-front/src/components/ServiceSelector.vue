<template>
  <div class="service-container">
    <div class="service-options">
      <div class="service-option" @click="selectService('Мойка')">
        <div class="service-square" :class="{ active: selectedService === 'Мойка' }">
          <img class="service-icon" src="../assets/carwash.png"><br>
          <span class="service-text">Мойка</span>
        </div>
      </div>
      <div class="service-option" @click="selectService('Шиномонтаж')">
        <div class="service-square" :class="{ active: selectedService === 'Шиномонтаж' }">
          <img class="service-icon" src="../assets/tires.png"><br>
          <span class="service-text">Шиномонтаж</span>
        </div>
      </div>
    </div>
    <a v-if="selectedService">Выбранная услуга: {{ selectedService }}</a>
    <router-link to="/organizationselect">
      <button id="select-button" @click="selectService(selectedService)">Выбрать услугу</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "ServiceSelector",
  data() {
    return {
      selectedService: null
    };
  },
  methods: {
    selectService(service) {
      this.selectedService = service;
      this.$emit("CategorySelected", service);
    }
  }
};
</script>

<style>
</style>
