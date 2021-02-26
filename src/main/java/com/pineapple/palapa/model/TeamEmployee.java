package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teamEmployee")
public class TeamEmployee implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 1002L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "team_id")
    private Team team;
    
    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String startTime;
    private String endTime;

    public TeamEmployee() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }



    @Override
    public String toString() {
        return "TeamEmployee {" +
        "id=" + id +
        "employee=" + employee +
        "team=" + team +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}";

    }

}