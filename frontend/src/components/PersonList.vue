<template>
    <div>
        <h2>List des Personnes</h2>
        <ul v-if="!loading">
            <li v-for="person in persones" :key="person.id"> {{ person.lastname }}</li>
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
    }
}
</script>