<template>
  <div class="org-container">
    <span>Выбор организации</span>
    <input class="org-searchbar" type="text" v-model="searchQuery" placeholder="Поиск организации">
    <div class="organization-list">
      <button class="org-name" v-for="org in filteredOrganizations" :key="org.id" @click="selectOrganization(org)">
        {{ org.shortName }}
      </button>
    </div>
    <div class="selected-org" v-if="selectedOrganization">
      <a>Выбранная организация: </a>
      <a>{{ selectedOrganization.shortName }}</a>
    </div>
    <router-link to="/servicestructure">
      <button class="accept-btn" @click="acceptOrganization">Принять</button>
    </router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "OrganizationSelector",
  data() {
    return {
      searchQuery: '',
      organizations: [],
      selectedOrganization: null
    };
  },
  created() {
    this.fetchOrganizations();
  },
  computed: {
    filteredOrganizations() {
      return this.organizations.filter(org =>
        org.shortName.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    }
  },
  methods: {
    fetchOrganizations() {
      axios.get('http://localhost:8060/organization/all/')
        .then(response => {
          this.organizations = response.data;
        })
        .catch(error => {
          console.error('Ошибка при загрузке организаций:', error);
        });
    },
    selectOrganization(org) {
      this.selectedOrganization = org;
    },
    acceptOrganization() {
  if (this.selectedOrganization) {

    console.log('id:', this.selectedOrganization.id);
    this.$emit('organizationSelected', this.selectedOrganization.id);
  } else {
    console.error('Ошибка: Организация не выбрана.');
  }
}
  }
};
</script>

<style></style>
