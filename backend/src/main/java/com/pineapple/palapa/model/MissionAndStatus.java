package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mission_and_status")
public class MissionAndStatus implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 10202L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String assignmentDate;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "mission_status_id")
    private MissionStatus missionStatus;

    public MissionAndStatus() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(MissionStatus missionStatus) {
        this.missionStatus = missionStatus;
    }

    @Override
    public String toString() {
        return "MissionAndStatus {" +
        "id=" + id +
        "mission=" + mission +
        "missionStatus=" + missionStatus +
        "assignmentDate=" + assignmentDate +
        "}";
    }
}
