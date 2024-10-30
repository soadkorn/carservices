<template>
  <html>

  <body class="main-container">
    <PageHeader :UserName="UserName" :SelectedOrgInn="SelectedOrgInn" />
    <router-view :SelectedOrgId="SelectedOrgId"
                 :UserName="UserName"
                 :SelectedServices="SelectedServices"
                 :ServiceCategory="ServiceCategory"
                 @OrganizationSelected="handleOrganizationSelected"
                 @ServicesAccepted="handleServicesAccepted"
                 @UserNameChanged="handleUserName"
                  @CategorySelected="handleCategory"/>
  </body>

  </html>
</template>

<script>
import PageHeader from './components/PageHeader.vue'


export default {
  components: {
    PageHeader,
  },
  data() {
    return {
      UserName: "Гость",
      SelectedOrgInn: null,
      SelectedOrgId: null,
      SelectedServices: [],
      ServiceCategory: ''
    };
  },
  methods: {
  handleOrganizationSelected(id) {
    console.log('id:', id);
    this.SelectedOrgId = parseInt(id);
  },
    handleServicesAccepted(selectedServices) {
      this.selectedServices = selectedServices;
      console.log('Выбранные услуги:', this.selectedServices);
    },
    handleUserName(userName) {
    this.UserName = userName;
    },
    handleCategory(category) {
    console.log(category);
    this.ServiceCategory = category;
    }
}

}
</script>

<style></style>
