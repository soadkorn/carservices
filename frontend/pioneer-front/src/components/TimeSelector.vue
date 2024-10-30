<template>

  <div class="date-time-container">
    <a>Выберите дату и время записи </a>
    <div class="date-selector">
      <button @click="selectToday">Сегодня</button>
      <button @click="selectTomorrow">Завтра</button>
    </div>
    <div class="select">
      <a class="time-picker-label">Выберите время: </a>
      <select class="select" v-model="selectedTimeHour">
        <option class="time-picker" v-for="hour in hours" :value="hour" :key="hour">{{ hour }}</option>
      </select>
      :
      <select class="select" v-model="selectedTimeMinute">
        <option class="time-picker" v-for="minute in minutes" :value="minute" :key="minute">{{ minute }}</option>
      </select>
    </div>
    <div class="selected-date-time">
      <a>Выбранная дата: {{ selectedDate }}</a>
      <a>Выбранное время: {{ selectedTimeHour }}:{{ selectedTimeMinute }}</a>
    </div>
    <div class="accept-button" v-if="selectedDate && selectedTimeHour && selectedTimeMinute">
      <router-link to="/confirmpage">
        <button @click="acceptAppointment">Принять</button>
      </router-link>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "AppointmentScheduler",
  props: {
    SelectedOrgId: {
      type: Number,
      required: true
    },
    SelectedServices: {
      type: Array,
      required: true
    },
    UserName: {
      type: String,
      required: true
    },
    ServiceCategory: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      selectedDate: '',
      selectedTimeHour: '00',
      selectedTimeMinute: '00',
      hours: [],
      minutes: [],
      orgAdressId: null
    };
  },
  mounted() {
    this.populateHoursAndMinutes();
    this.fetchAddress(this.SelectedOrgId);
    console.log('Выбранный организационный идентификатор:', this.SelectedOrgId);
    console.log('Тип услуги: ', this.ServiceCategory);
    console.log('Электронная почта:', this.UserName);
  },
  methods: {
    fetchAddress(SelectedOrgId) { // Передаем SelectedOrgId как параметр
      // Отправка POST-запроса на сервер для получения адреса
      axios.post(`http://localhost:8060/address/?organizationId=${SelectedOrgId}`)
          .then(response => {
            // Обновление адреса после получения данных от сервера
            this.orgAdressId = response.data.id;
            console.log('Успешно загружен адрес:', this.orgAdressId);
          })
          .catch(error => {
            console.error('Ошибка при загрузке адреса:', error);
          });
    },
    populateHoursAndMinutes() {
      for (let i = 0; i < 24; i++) {
        this.hours.push(i.toString().padStart(2, '0'));
      }
      for (let i = 0; i < 60; i += 15) {
        this.minutes.push(i.toString().padStart(2, '0'));
      }
    },
    selectToday() {
      this.selectedDate = this.formatDate(new Date());
      console.log(this.selectedDate)
    },
    selectTomorrow() {
      const tomorrow = new Date();
      tomorrow.setDate(tomorrow.getDate() + 1);
      this.selectedDate = this.formatDate(tomorrow);
    },
    formatDate(date) {
      const formattedDate = date.toISOString().slice(0, 16);
      return formattedDate;
    },
    acceptAppointment() {
      if (this.selectedDate && this.selectedTimeHour && this.selectedTimeMinute) {
        const dateTime = `${this.selectedDate}:00.000Z`;
        axios.post('http://localhost:8060/order/', {
          client_email: this.UserName,
          service_detail_name: this.ServiceCategory,
          organization_id: this.SelectedOrgId,
          service_details_ids: [0],
          date_of_order: dateTime,
          organization_address_id: this.orgAdressId
        })
        console.log(`Запись на ${dateTime} успешно принята!`);
        // Далее можно сохранить dateTime или отправить его куда-либо
      } else {
        console.log('Пожалуйста, выберите дату и время записи.');
      }
    }
  }
};
</script>
