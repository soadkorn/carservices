<template>
  <div class="service-structure">
    <h2>Выбор услуг</h2>
    <div>
      <p>Итоговая сумма: {{ totalAmount }}</p>
      <p>Итоговое время: {{ totalTime }}</p>
    </div>
    <ul class="service-list">
      <li class="service-item" v-for="(service, index) in services" :key="service.id">
        <label>
          <input type="checkbox" v-model="selectedServices[index]">
          {{ service.service_detail_name }}
        </label>
        <div class="service-details">
          Цена: {{ service.service_detail_cost }} руб. - Время: {{ service.service_detail_duration }} часов
        </div>
      </li>
    </ul>
    <div>
      <RouterLink to="/timeselect">
        <button @click="acceptService" :disabled="selectedServices.length === 0">Принять</button>
      </RouterLink>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'ServiceSelection',
  props: {
    SelectedOrgId: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      companyName: 'Pioneer',
      selectedServices: [],
      services: []
    };
  },
  created() {
    this.fetchServices(this.SelectedOrgId);
  },
  methods: {
    fetchServices(SelectedOrgId) {
      if (SelectedOrgId) {
        console.log('Запрос на сервер для получения услуг. Организация:', SelectedOrgId);
        axios.post(`http://localhost:8060/organizationService/?organizationId=${SelectedOrgId}`)
          .then(response => {
            // Обновление списка услуг после получения данных от сервера
            this.services = response.data;
            this.selectedServices = new Array(this.services.length).fill(false); // Инициализация массива выбранных услуг
            console.log('Успешно загружены услуги:', this.services);
          })
          .catch(error => {
            console.error('Ошибка при загрузке услуг:', error);
          });
      }
    },
    acceptService() {
      // Создаем массив объектов выбранных услуг
      const selectedServices = this.selectedServices
          .map((isSelected, index) => ({
            isSelected, // Флаг выбранности услуги
            service: this.services[index] // Объект услуги
          }))
          .filter(({ isSelected }) => isSelected); // Отфильтровываем только выбранные услуги

      console.log('Услуги приняты!');
      this.$emit('servicesAccepted', selectedServices);
    }
  },

  computed: {
    totalAmount() {
      let total = 0;
      for (let i = 0; i < this.selectedServices.length; i++) {
        if (this.selectedServices[i]) {
          total += this.services[i].service_detail_cost;
        }
      }
      return total;
    },
    totalTime() {
      let total = 0;
      for (let i = 0; i < this.selectedServices.length; i++) {
        if (this.selectedServices[i]) {
          total += this.services[i].service_detail_duration;
        }
      }
      return total + ' часов';
    }
  }
};
</script>

<style></style>
