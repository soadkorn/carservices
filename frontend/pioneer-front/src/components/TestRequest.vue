<script>
import axios from 'axios'

export default {
  data() {
    return {
      responseData: '' // Строка для хранения данных
    };
  },
  methods: {
    fetchData() {

      axios.get('http://localhost:8060/user/mock')
        .then(response => {
          // Обработка успешного ответа
          this.responseData = JSON.stringify(response.data);
        })
        .catch(error => {
          // Обработка ошибки
          console.error('Ошибка при запросе:', error);
        });
    }
  }
};
</script>
<style>
</style>

<template>

  <body class="TestReqMainCont">
      <p>Mock-Up object check</p>
      <button @click="fetchData" class="FetchButton">FETCH DATA</button>
      <div class="ResponseContainer"><p>{{ responseData }}</p></div>

  </body>
</template>