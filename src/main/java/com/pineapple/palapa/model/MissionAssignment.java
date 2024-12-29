package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "missionAssignment")
public class MissionAssignment implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 1002L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String assignmentTime;

    public MissionAssignment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStartTime() {
        return assignmentTime;
    }

    public void setStartTime(String assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    @Override
    public String toString() {
        return "MissionAssignment {" +
        "id=" + id +
        "employee=" + employee +
        "mission=" + mission +
        ", assignmentTime=" + assignmentTime +
        "}";

    }

}