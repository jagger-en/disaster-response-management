package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    private String joinDate;

    @OneToMany(mappedBy="employee", cascade=CascadeType.REMOVE)
    Collection<TeamEmployee> teamEmployees;

    public Employee() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }


    @Override
    public String toString() {
        return "Employee {" +
        "id=" + id +
        "person=" + person +
        "jobTitle=" + jobTitle +
        "joinDate=" + joinDate +
        "}";
    }

}