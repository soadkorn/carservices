<template>
  <div class="background-container">
    <div class="container mx-auto relative">
      <img src="./pioneer.png" alt="Логотип" class="logo">
      <div class="underlogo-text">
        <h2 class="title">Добро пожаловать </h2>
      </div>
      <div class="registration-form flex justify-center items-center">
        <form action="index.html" method="post">
          <div class="form-group mb-4">
            <label for="username" class="input-label">Имя пользователя:</label>
            <input type="text" id="username" name="username" placeholder="Введите ваше имя" required class="border rounded-md p-3 w-full text-lg placeholder-gray-400 focus:placeholder-gray-600 bg-custom-gray">
          </div>
          <div class="form-group mb-4">
            <label for="email" class="input-label">Email:</label>
            <input type="email" id="email" name="email" placeholder="example@example.com" required class="border rounded-md p-3 w-full text-lg placeholder-gray-400 focus:placeholder-gray-600 bg-custom-gray">
          </div>
          <div class="form-group mb-4">
            <label for="password" class="input-label">Пароль:</label>
            <input type="password" id="password" name="password" placeholder="Введите ваш пароль" required class="border rounded-md p-3 w-full text-lg placeholder-gray-400 focus:placeholder-gray-600 bg-custom-gray">
          </div>
          <div class="forgot-password-container mb-4 flex justify-center w-full">
            <a href="#" class="forgot-password text-blue-500 hover:text-blue-700">Забыли пароль?</a>
          </div>
          <div class="submit-buttons mb-4 flex flex-row justify-between">
            <input type="submit" class="login-option bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-md mb-2 w-full" value="Регистрация">
            <input type="submit" class="login-option bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded-md mb-2 w-full" value="Вход">
          </div>
          <div class="or-divider my-2 w-full flex items-center justify-center">
            <div class="line flex-1 h-0.5 bg-gray-300"></div>
            <div class="mx-4 text-gray-500 font-bold">или</div>
            <div class="line flex-1 h-0.5 bg-gray-300"></div>
          </div>
        </form>
        <div class="login-options mb-8">
          <button onclick="window.location.href='https://accounts.google.com'" class="login-option bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded block mb-2 w-full">Авторизоваться с помощью Google</button>
          <button onclick="window.location.href='https://vk.com'" class="login-option bg-yellow-500 hover:bg-yellow-700 text-white font-bold py-2 px-4 rounded block mb-2 w-full">Авторизоваться с помощью VK</button>

        </div>
      </div>
    </div>
  </div>
</template>

<style>
</style>