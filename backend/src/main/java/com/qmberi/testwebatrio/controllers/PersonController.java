package com.qmberi.testwebatrio.controllers;

import com.qmberi.testwebatrio.domains.Person;
import com.qmberi.testwebatrio.domains.PersonJob;
import com.qmberi.testwebatrio.dto.JobsDTO;
import com.qmberi.testwebatrio.dto.PersonDTO;
import com.qmberi.testwebatrio.services.EnterpriseService;
import com.qmberi.testwebatrio.services.PersonService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
@CrossOrigin(origins = "*")
public class PersonController {

    private EnterpriseService enterpriseService;
    private PersonService personService;

    public PersonController(EnterpriseService enterpriseService, PersonService personService) {
        this.enterpriseService = enterpriseService;
        this.personService = personService;
    }

    @PostMapping("")
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        Optional<Person> person = personService.createPerson(personDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(person.get());
    }

    @GetMapping("")
    public List<Person> listPersons() {
        return personService.findAll();
    }

    @GetMapping("/workin/{name}")
    public List<Person> findPersonsWorkInEnterprise(@PathVariable("name") String name) {

        return personService.findAllPersonWhoWorkInEnterprise(name);
    }

    @GetMapping("/{personId}")
    public List<PersonJob> findPersonsWorkInEnterprise(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @PathVariable("personId") Integer personId) {

        return personService.getAllJobsOfPersonBetweenDates(personId,startDate, endDate);
    }

    @PostMapping("/{personId}")
    public ResponseEntity<PersonJob> addWorkToPerson(@RequestBody JobsDTO personJob, @PathVariable("personId") Integer personID) {

        Person person = personService.findById(personID);

        return ResponseEntity.status(HttpStatus.CREATED).body(personService.addJobToPerson(personJob, person));
    }
}
