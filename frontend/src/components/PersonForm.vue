<template>
    <form @submit.prevent="submitForm">
      <!-- Informations personnelles -->
      <div>
        <label for="firstname">Prénom:</label>
        <input id="firstname" v-model="form.firstname" type="text" required />
      </div>
      <div>
        <label for="lastname">Nom:</label>
        <input id="lastname" v-model="form.lastname" type="text" required />
      </div>
      <div>
        <label for="birthDate">Date de naissance:</label>
        <input id="birthDate" v-model="form.birthDate" type="date" required />
      </div>

      <!-- Tableau des jobs -->
      <h2>Jobs</h2>
      <div v-for="(job, index) in form.jobs" :key="index" class="job-entry">
        <div>
          <label :for="'job-name-' + index">Nom du Job:</label>
          <input
            :id="'job-name-' + index"
            v-model="job.name"
            type="text"
            placeholder="Nom du job"
            required
          />
        </div>
        <div>
          <label :for="'job-start-' + index">Date de début:</label>
          <input
            :id="'job-start-' + index"
            v-model="job.startDate"
            type="date"
            required
          />
        </div>
        <div>
          <label :for="'job-end-' + index">Date de fin:</label>
          <input
            :id="'job-end-' + index"
            v-model="job.endDate"
            type="date"
            required
          />
        </div>
        <button type="button" @click="removeJob(index)">Supprimer ce job</button>
      </div>
      <button type="button" @click="addJob">Ajouter un Job</button>

      <!-- Bouton de soumission -->
      <button type="submit">Soumettre</button>
    </form>
</template>
<script>
import { usePersonStore } from '@/stores/PersonStore';
import { ref } from 'vue';

export default {
    setup() {
      // Formulaire réactif
        const form = ref({
        firstname: "",
        lastname: "",
        birthDate: "",
        jobs: [
            {
            name: "",
            startDate: "",
            endDate: "",
            },
        ],
        });

        // Indicateur pour savoir si le formulaire a été soumis
        const submitted = ref(false);

        // Ajouter un job vide
        const addJob = () => {
        form.value.jobs.push({
            name: "",
            startDate: "",
            endDate: "",
        });
        };

        // Supprimer un job
        const removeJob = (index) => {
        form.value.jobs.splice(index, 1);
        };

        // Soumettre le formulaire
        const submitForm = () => {
        submitted.value = true;
        console.log("Formulaire soumis :", form.value);
        };

        return {
        form,
        submitted,
        addJob,
        removeJob,
        submitForm,
        };
    }
};
</script>


<style>
body {
  font-family: Arial, sans-serif;
}

form {
  margin-bottom: 20px;
}

.job-entry {
  margin-bottom: 10px;
  border: 1px solid #ccc;
  padding: 10px;
  border-radius: 5px;
}

button {
  margin-top: 10px;
  padding: 5px 10px;
  cursor: pointer;
}

button[type="submit"] {
  background-color: #4caf50;
  color: white;
  border: none;
}

button[type="button"] {
  background-color: #f44336;
  color: white;
  border: none;
}

h2 {
  margin-top: 20px;
}
</style>