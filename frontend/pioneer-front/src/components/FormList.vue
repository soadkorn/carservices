<template>
  <div class="filters">
    <button @click="selectStatus('Новая')">Новая</button>
    <button @click="selectStatus('В работе')">В работе</button>
    <button @click="selectStatus('Исполнена')">Исполнена</button>
    <button @click="selectStatus('Отклонена')">Отклонена</button>
  </div>
  <div class="form-list">
    <div v-if="forms.length > 0">
      <h2>{{ selectedStatus }}</h2>
      <div>
        <table>
          <thead>
          <tr>
            <th>Рег. №</th>
            <th>Дата создания</th>
            <th>Краткое наименование организации</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="form in forms" :key="form.id">
            <td>{{ form[1] }}</td> <!-- Первая ячейка -->
            <td>{{ formatDate(form[0]) }}</td> <!-- Вторая ячейка -->
            <td>{{ form[2] }}</td> <!-- Третья ячейка -->
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      selectedStatus: '',
      forms: []
    };
  },
  methods: {
    selectStatus(status) {
      this.selectedStatus = status;
      this.fetchForms(status);
    },
    fetchForms(status) {
      axios.post(`http://localhost:8060/connectionOrganization/?status=${status}`)
          .then(response => {
            this.forms = response.data;
          })
          .catch(error => {
            console.error('Error fetching forms:', error);
          });
    },
    formatDate(timestamp) {
      const date = new Date(parseInt(timestamp));
      return date.toLocaleDateString();
    }
  }
};
</script>
