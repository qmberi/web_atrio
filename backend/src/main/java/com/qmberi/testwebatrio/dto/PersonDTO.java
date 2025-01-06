package com.qmberi.testwebatrio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class PersonDTO {

    @NotBlank(message = "Should not be blank")
    @Size(min = 3, max = 50, message = "Person name must be between 3 and 50 characters")
    private String lastname;

    @NotBlank(message = "Should not be blank")
    @Size(min = 3, max = 50, message = "Person name must be between 3 and 50 characters")
    private String firstname;

    private List<JobsDTO> jobs;

    private Date birthDate;

    public List<JobsDTO> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobsDTO> jobs) {
        this.jobs = jobs;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastname() {
        return lastname;
    }

    public void setlastname(String name) {
        this.lastname = name;
    }
}
