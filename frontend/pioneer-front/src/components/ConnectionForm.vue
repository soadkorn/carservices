<template>
  <div class="org-connection-container">
    <div class="header">
      <h2>Форма подключения к приложению Pioneer</h2>
    </div>
    <div class="header">
      <div class="status">
        <a class="input-label">Текущий статус: </a>
        <span>{{ currentStatus }}</span>
      </div>
      <div class="dates">
        <a class="input-label">Дата создания: </a>
        <span>{{ creationDate }}</span>
        <br>
        <a class="input-label">Дата исполнения/отклонения: </a>
        <span>{{ executionDate }}</span>
      </div>
    </div>
    <div class="form-section organization-section">
      <h3>Организация</h3>
      <div class="form-group">
        <a class="input-label" for="full-name">Полное наименование</a>
        <input type="text" class="base-input" v-model="organization.fullName" />
        <div v-if="errors.organization.fullName" class="error-message">{{ errors.organization.fullName }}</div>
      </div>
      <div class="form-group">
        <a class="input-label" for="short-name">Краткое наименование</a>
        <input type="text" class="base-input" v-model="organization.shortName" />
        <div v-if="errors.organization.shortName" class="error-message">{{ errors.organization.shortName }}</div>
      </div>
      <div class="form-group">
        <a class="input-label" for="inn">ИНН</a>
        <input type="text" class="base-input" v-model="organization.inn" />
        <div v-if="errors.organization.inn" class="error-message">{{ errors.organization.inn }}</div>
      </div>
      <div class="form-group">
        <a class="input-label">КПП</a>
        <input type="text" class="base-input" v-model="organization.kpp" />
        <div v-if="errors.organization.kpp" class="error-message">{{ errors.organization.kpp }}</div>
      </div>
      <div class="form-group">
        <a class="input-label" for="ogrn">ОГРН</a>
        <input type="text" class="base-input" v-model="organization.ogrn" />
        <div v-if="errors.organization.ogrn" class="error-message">{{ errors.organization.ogrn }}</div>
      </div>
    </div>
    <div class="form-section contact-section">
      <h3>Контактное лицо</h3>
      <div class="form-group">
        <a class="input-label">E-mail</a>
        <input type="email" class="base-input" v-model="contact.email" />
        <div v-if="errors.contact.email" class="error-message">{{ errors.contact.email }}</div>
      </div>
    </div>
    <button @click="submitForm">Отправить</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ConnectionForm",
  data() {
    return {
      currentStatus: 'Новая',
      creationDate: '01.03.2024',
      executionDate: '05.03.2024',
      organization: {
        fullName: '',
        shortName: '',
        inn: '',
        kpp: '',
        ogrn: ''
      },
      contact: {
        email: ''
      },
      errors: {
        organization: {},
        contact: {}
      }
    };
  },
  methods: {
    submitForm() {
      this.errors.organization = {};
      this.errors.contact = {};

      let hasErrors = false;

      // Проверка на валидность полей организации
      if (!this.organization.fullName.trim()) {
        this.errors.organization.fullName = "Введите полное наименование";
        hasErrors = true;
      }
      // остальные проверки на валидность полей организации...

      // Проверка на валидность поля контактного лица
      if (!this.contact.email.trim() || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.contact.email)) {
        this.errors.contact.email = "Введите корректный e-mail";
        hasErrors = true;
      }

      if (hasErrors) {
        return; // Не отправляем форму, если есть ошибки
      }

      // Отправка данных на сервер
      axios.post('http://localhost:8060/organization/', {
        id: 0,
        fullName: this.organization.fullName,
        shortName: this.organization.shortName,
        inn: this.organization.inn,
        kpp: this.organization.kpp,
        ogrn: this.organization.ogrn,
        addInfo: '', // добавьте нужные данные или оставьте пустыми
        responsiblePersonEmail: this.contact.email
      })
          .then(response => {
            // Обработка успешного ответа сервера
            console.log('Успешно отправлено:', response.data);
            // Дополнительные действия, например, переход на следующую страницу
            alert
            this.$router.push('/');
          })
          .catch(error => {
            // Обработка ошибки
            console.error('Ошибка при отправке данных:', error);
            // Дополнительные действия, например, вывод сообщения об ошибке пользователю
          });
    }
  }
};
</script>


