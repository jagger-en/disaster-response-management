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

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "team_id")
    private Team team;

    private String joinDate;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
        "team=" + team +
        "joinDate=" + joinDate +
        "}";
    }

}