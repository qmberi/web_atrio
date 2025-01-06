import { defineStore } from 'pinia';
import apiClient from '@/../utils/api.js';

export const usePersonStore = defineStore('person', {
    state: () => ({
        persons: [],
        loading: false
    }),
    actions: {
        async fetchPersons() {
            this.loading = true;
            try {
                const response = await apiClient.get('/person');

                this.persons = response.data;
            } catch (error) {
                console.error('Erreur de la récuperationdes données');
            } finally {
                this.loading = false;
            }
        },
        async createPerson(data) {
            try {
                const response = await apiClient.post('/person', { data });

                this.persons.push(response.data);
            } catch (error) {
                console.error("Erreur lors de la creation de la personne ", error);
            }
        }
    }
});