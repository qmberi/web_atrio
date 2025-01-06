package com.qmberi.testwebatrio.services;

import com.qmberi.testwebatrio.domains.Enterprise;
import com.qmberi.testwebatrio.domains.Person;
import com.qmberi.testwebatrio.domains.PersonJob;
import com.qmberi.testwebatrio.dto.JobsDTO;
import com.qmberi.testwebatrio.dto.PersonDTO;
import com.qmberi.testwebatrio.repositories.EnterpriseRepository;
import com.qmberi.testwebatrio.repositories.PersonJobRepository;
import com.qmberi.testwebatrio.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private EnterpriseRepository enterpriseRepository;
    private PersonJobRepository personJobRepository;

    public PersonService(PersonRepository personRepository, EnterpriseRepository enterpriseRepository, PersonJobRepository personJobRepository) {
        this.personRepository = personRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.personJobRepository = personJobRepository;
    }


    public Optional<Person> createPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setLastname(personDTO.getLastname());
        person.setFirstname(personDTO.getFirstname());
        person.setBirthDate(personDTO.getBirthDate());
        person = personRepository.save(person);
        Person finalPerson = person;

        personDTO.getJobs().forEach(jobsDTO -> addJobToPerson(jobsDTO, finalPerson));

        return personRepository.findById(finalPerson.getId());
    }
    public List<Person> findAll() {
        return personRepository.findAll().stream().toList();
    }

    public List<Person> findAllPersonWhoWorkInEnterprise (String name) {
        return personRepository.findAllPersonWorkWithAnEnterprise(name);
    }

    public List<PersonJob> getAllJobsOfPersonBetweenDates (Integer personId,Date stardDate, Date endDate) {
        List<PersonJob> personJobs = personJobRepository.findAllByStartDateBetweenAndPersonId(stardDate, endDate, personId);
        return personJobs;
    }

    public PersonJob addJobToPerson(JobsDTO jobDto, Person person) {
        Optional<Enterprise> enterprise = enterpriseRepository.findEnterpriseByName(jobDto.getEnterprise());
        if (enterprise.isEmpty()) {
            Enterprise newEnterprise = new Enterprise();
            newEnterprise.setName(jobDto.getEnterprise());
            enterprise = Optional.of(enterpriseRepository.save(newEnterprise));
        }
        PersonJob newJob = new PersonJob();
        newJob.setPerson(person);
        newJob.setName(jobDto.getJobTitle());
        newJob.setCurrent(jobDto.getCurrent());
        newJob.setEnterprise(enterprise.get());
        newJob.setStartDate(jobDto.getStartDate());
        newJob.setEndDate(jobDto.getEndDate());
        return personJobRepository.save(newJob);
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElseThrow();
    }
}
