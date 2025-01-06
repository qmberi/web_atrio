<template>
    <form @submit.prevent="submitForm">
        <input type="text" v-model="firstname" required>
        <input type="text" v-model="lastname" required>
        <button type="submit">Ajouter</button>
    </form>
</template>
<script>
import { usePersonStore } from '@/stores/PersonStore';
import { ref } from 'vue';

export default {
    setup() {
        const personStore = usePersonStore();
        const firstname = ref('');
        const lastname = ref('');

        const submitForm = async () => {
            let personData = {
                lastname: lastname,
                firstname: firstname
            }
            await personStore.createPerson(personData);

            //FLUSH ALL
            lastname.value = '';
            firstname.value = '';

        }

        return {
            firstname,
            lastname,
            submitForm
        }
    }
};
</script>