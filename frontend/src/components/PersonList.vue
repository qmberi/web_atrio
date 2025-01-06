<template>
    <div>
        <h2>List des Personnes</h2>
        <ul v-if="!loading">
            <li v-for="person in persones" :key="person.id"> 
                <strong>{{ person.firstname }} {{ person.lastname }}</strong> - 
                Âge : {{ calculateAge(person.birthDate) }} ans
                <br />
                Job principal : 
                <span v-if="person.jobs && person.jobs.length > 0">
                {{ person.jobs[0].name }} chez {{ person.jobs[0].enterprise.name }} ({{ person.jobs[0].startDate }} - 
                <span v-if="person.jobs[0].isCurrent">Actuel</span>
                <span v-else>{{ person.jobs[0].endDate }}</span>)
                </span>
                <span v-else>Aucun job</span>
            </li>
        </ul>
        <p v-else>Chargement..</p>
    </div>
</template>
<script>
import { usePersonStore } from '@/stores/PersonStore';
import { computed } from 'vue';
import { onMounted } from 'vue';
export default {
    setup() {
        const personStore = usePersonStore();

        onMounted(() => {
            personStore.fetchPersons();
        })

        return {
            persones: computed(() => personStore.persons),
            loading: computed(() => personStore.loading)
        }
    },
    methods: {
        
        calculateAge(birthDate) {
        const birth = new Date(birthDate);
        const today = new Date();
        let age = today.getFullYear() - birth.getFullYear();
        const monthDiff = today.getMonth() - birth.getMonth();
        if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birth.getDate())) {
            age--;
        }
        return age;
        },
    },
}
</script>


<style>
body {
  font-family: Arial, sans-serif;
}

h1 {
  color: #333;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 10px;
  border-bottom: 1px solid #ccc;
  padding-bottom: 10px;
}

strong {
  color: #4caf50;
}
</style>