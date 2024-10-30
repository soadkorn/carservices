import { createApp } from 'vue'
import { createWebHistory, createRouter } from 'vue-router';
import App from './App.vue'
import './assets/main.css'
import UserType from './components/UserType.vue';
import UserLogin from './components/UserLogin.vue';
import ServiceSelector from "@/components/ServiceSelector.vue";
import OrganizationSelector from "@/components/OrganizationSelector.vue";
import ServiceStructure from "@/components/ServiceStructure.vue";
import TimeSelector from "@/components/TimeSelector.vue";
import ConfirmPage from "@/components/ConfirmPage.vue";
import ConnectionForm from "@/components/ConnectionForm.vue";
import FormList from "@/components/FormList.vue";
import RegistrationPage from "@/components/RegistrationPage.vue";


const app = createApp(App)

const routes = [
    { path: '/', name: 'UserType', component: UserType },
    { path: '/userlogin', name: 'UserLogin', component: UserLogin },
    { path: '/serviceselect', name: 'ServiceSelector', component: ServiceSelector },
    { path: '/organizationselect', name: 'OrganizationSelector', component: OrganizationSelector },
    { path: '/servicestructure', name: 'ServiceStructure', component: ServiceStructure },
    { path: '/timeselect', name: 'TimeSelector', component: TimeSelector },
    { path: '/confirmpage', name: 'ConfirmPage', component: ConfirmPage },
    { path: '/connectionform', name: 'ConnectionForm', component: ConnectionForm },
    { path: '/formlist', name: 'FormList', component: FormList },
    { path: '/registrationpage', name: 'RegistrationPage', component: RegistrationPage },

]

const router = createRouter({
    history: createWebHistory(),
    routes
})

app.use(router)

app.mount('#app')

