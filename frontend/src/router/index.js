import { createRouter, createWebHistory } from 'vue-router';
import PersonsVue from '@/views/PersonsVue.vue';

const routes = [
    { path: '/', name: 'PersonsVue', component: PersonsVue }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;