<template>
  <div class="login-container">
    <div v-if="showBothFieldsEmptyError" class="error-message">Введите e-mail и пароль</div>
    <div v-if="showLoginAttempt && emailError" class="error-message">{{ emailError }}</div>
    <input class="email-input" type="email" v-model="email" :class="{ 'shake-animation': showLoginAttempt && emailError }" placeholder="e-mail"><br>
    <div v-if="showLoginAttempt && passwordError" class="error-message">{{ passwordError }}</div>
    <input class="pass-input" type="password" v-model="password" :class="{ 'shake-animation': showLoginAttempt && passwordError }" placeholder="пароль"><br>
  </div>
  <div class="login-buttons">
    <button class="login-button" @click="login">Вход</button>
    <RouterLink to="/registrationpage">
    <button class="login-button" @click="register">Регистрация</button>
    </RouterLink>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      email: '',
      password: '',
      emailError: '',
      passwordError: '',
      showBothFieldsEmptyError: false,
      showLoginAttempt: false // Флаг для отображения ошибок только после попытки входа
    };
  },
  methods: {
    validateEmail(email) {
      return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    },
    login() {
      this.showLoginAttempt = true; // Устанавливаем флаг попытки входа

      this.emailError = '';
      this.passwordError = '';
      this.showBothFieldsEmptyError = false;

      if (!this.email.trim() && !this.password.trim()) {
        this.showBothFieldsEmptyError = true;
        return;
      }

      if (!this.email.trim()) {
        this.emailError = "Введите e-mail";
        return;
      }

      if (!this.password.trim()) {
        this.passwordError = "Введите пароль";
        return;
      }

      if (!this.validateEmail(this.email)) {
        this.emailError = "Введите правильный e-mail адрес!";
        return;
      }

      // Здесь можно добавить логику для входа
      axios.post('http://localhost:8060/user/login/', {
        email: this.email,
        password: this.password
      })
          .then(response => {
            if (response.data) {
              console.log('Ответ сервера:', response.data);
              this.$emit('UserNameChanged', this.email);
              console.log(this.email);
              this.$router.push('/serviceselect');
            } else {
              console.log('Ответ сервера пустой');
              alert('Неправильный логин или пароль');
            }
          })
          .catch(error => {
            console.error('Ошибка запроса:', error);
          });

    },
    register() {
      // Здесь можно добавить логику для регистрации
      console.log('Выполняется регистрация с почтой:', this.email, 'и паролем:', this.password);
    }
  }

};
</script>

