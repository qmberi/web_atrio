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
            v-model="job.jobTitle"
            type="text"
            placeholder="Nom du job"
            required
          />
        </div>
        <div>
          <label :for="'enterpris-' + index">Nom de la boite:</label>
          <input
            :id="'enterpris-' + index"
            v-model="job.enterprise"
            type="text"
            placeholder="Nom de la boite"
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
          <label :for="'job-current-' + index">Job actuel:</label>
          <input
            type="checkbox"
            :id="'job-current-' + index"
            v-model="job.isCurrent"
          />
        </div>
        <div>
          <label :for="'job-end-' + index">Date de fin:</label>
          <input
            :id="'job-end-' + index"
            v-model="job.endDate"
            type="date"
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
        const initialFormData = {
          firstname: "Quentin",
          lastname: "Mberi",
          birthDate: "",
          jobs: [
            {
              jobTitle: "dev",
              startDate: "",
              endDate: "",
              enterprise: "",
              isCurrent: false
            },
          ],
        };
        const personStore = usePersonStore();
        const form = ref({ ...initialFormData });

        // Indicateur pour savoir si le formulaire a été soumis
        const submitted = ref(false);

        // Ajouter un job vide
        const addJob = () => {
            form.value.jobs.push({
                jobTitle: "",
                enterprise: "",
                isCurrent:false,
                startDate: "",
                endDate: "",
            });
        };

        // Supprimer un job
        const removeJob = (index) => {
            form.value.jobs.splice(index, 1);
        };

        // Soumettre le formulaire
        const submitForm = async () => {
            submitted.value = true;

            await personStore.createPerson(form.value);

            // Réinitialiser le formulaire
            //form.value = { ...initialFormData };
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