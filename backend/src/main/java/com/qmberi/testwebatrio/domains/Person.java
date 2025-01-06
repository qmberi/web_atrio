package com.qmberi.testwebatrio.domains;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "lastname")
    private String lastname;
    @Column(columnDefinition = "firstname")
    private String firstname;

    @Column(columnDefinition = "birth_date")
    private Date birthDate;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonJob> jobs;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<PersonJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<PersonJob> jobs) {
        this.jobs = jobs;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }
}
