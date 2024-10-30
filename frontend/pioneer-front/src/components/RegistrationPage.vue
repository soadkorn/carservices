<template>
  <div class="login-container">
    <div class="error-message" v-if="emailError" :class="{ 'shake': emailError }">{{ emailError }}</div>
    <input class="email-input" type="email" v-model="email" placeholder="e-mail">
    <div v-if="passwordError" class="error-message" :class="{ 'shake': passwordError }">{{ passwordError }}</div>
    <input class="pass-input" type="password" v-model="password" placeholder="пароль">
    <input class="pass-input" type="password" v-model="confirmPassword" placeholder="подтвердите пароль">
  </div>
  <div class="login-buttons">
    <button @click="registerUser">Зарегистрироваться</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      password: '',
      confirmPassword: '',
      emailError: '',
      passwordError: ''
    };
  },
  methods: {
    validateEmail(email) {
      return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    },
    registerUser() {
      this.emailError = '';
      this.passwordError = '';

      if (!this.email.trim() && !this.password.trim()) {
        this.emailError = "Введите e-mail адрес!";
        this.passwordError = "Введите пароль!";
        this.shakeInputs();
        return;
      }

      if (!this.email.trim()) {
        this.emailError = "Введите e-mail адрес!";
        this.shakeInputs();
        return;
      }

      if (!this.password.trim()) {
        this.passwordError = "Введите пароль!";
        this.shakeInputs();
        return;
      }

      if (!this.validateEmail(this.email)) {
        this.emailError = "Введите правильный e-mail адрес!";
        this.shakeInputs();
        return;
      }

      if (!this.containsLatinCharacters(this.password)) {
        this.passwordError = "Пароль должен содержать латинские символы!";
        this.shakeInputs();
        return;
      }

      if (this.password !== this.confirmPassword) {
        this.passwordError = "Пароли не совпадают!";
        this.shakeInputs();
        return;
      }
      console.log('Регистрация пользователя...');
    },
    containsLatinCharacters(str) {
      return /[a-zA-Z0-9]/.test(str);
    },

    shakeInputs() {
      // Добавить класс для тряски ввода
      const inputs = document.querySelectorAll('.email-input, .pass-input');
      inputs.forEach(input => {
        input.classList.add('shake-animation');
        setTimeout(() => {
          input.classList.remove('shake-animation');
        }, 500); // Удалить класс после 500 миллисекунд
      });
    }
  }
};
</script>
