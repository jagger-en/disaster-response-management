package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {



    /**
     * A serial was added
     */
    private static final long serialVersionUID = 6925468305551598973L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String jobTitle;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;





    public Employee() {}

    public Employee(String firstName, String lastName, String jobTitle, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    @Override
    public String toString() {
        return "Employee {" +
        "id=" + id +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", jobTitle=" + jobTitle +
        ", phoneNumber=" + phoneNumber +
        ", email=" + email +
        "}";

    }

}