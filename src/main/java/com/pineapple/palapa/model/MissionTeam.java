package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "missionTeam")
public class MissionTeam implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 1002L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "team_id")
    private Team team;

    private String startTime;
    private String endTime;

    public MissionTeam() {}

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
        return "MissionTeam {" +
        "id=" + id +
        "mission=" + mission +
        "team=" + team +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}";

    }

}