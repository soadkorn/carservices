<template>
  <div class="confirmation-page">
    <div class="confirmation-message">
      <p class="address">Ждём вас по адресу: {{ address }}</p>
    </div>
    <div class="confirmation-button">
      <router-link to="/">
        <button @click="confirm">Подтвердить</button>
      </router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      address: '', // Инициализация адреса
    };
  },
  props: ['SelectedOrgId'], // Если SelectedOrgId передается как пропс
  created() {
    // Вызов метода для получения адреса
    this.fetchAddress(this.SelectedOrgId); // Используйте this.SelectedOrgId, если передается как пропс
  },
  methods: {
    fetchAddress(SelectedOrgId) { // Передаем SelectedOrgId как параметр
      // Отправка POST-запроса на сервер для получения адреса
      axios.post(`http://localhost:8060/address/?organizationId=${SelectedOrgId}`)
          .then(response => {
            // Обновление адреса после получения данных от сервера
            this.address = `${response.data.subjectName}, ${response.data.cityName},
             ${response.data.streetName}, ${response.data.houseNumber}`;
            console.log('Успешно загружен адрес:', this.address);
          })
          .catch(error => {
            console.error('Ошибка при загрузке адреса:', error);
          });
    },
    confirm() {
      console.log("Подтверждено");

    },
  },
};
</script>

<style>
</style>
