<template>
    <div>
        <h1>Gestion des Personnes</h1>
        <PersonForm></PersonForm>
        <PersonList></PersonList>
    </div>
</template>
<script>
import PersonForm from '@/components/PersonForm.vue';
import PersonList from '@/components/PersonList.vue';

export default {
    name: 'PersonsVue',
    components: {
        PersonForm,
        PersonList
    }
}
</script>