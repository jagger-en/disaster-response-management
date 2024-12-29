package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "mission")
public class Mission implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 415676199798147L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "mission_status_id")
    private MissionStatus missionStatus;

    private Long statusTtl;

    private String startTime;
    private String endTime;

    @OneToMany(mappedBy="mission", cascade=CascadeType.REMOVE)
    Collection<MissionAssignment> missionAssignments;

    public Mission() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(MissionStatus missionStatus) {
        this.missionStatus = missionStatus;
    }

    public Long getStatusTtl() {
        return statusTtl;
    }

    public void setStatusTtl(Long statusTtl) {
        this.statusTtl = statusTtl;
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
        return "Mission {" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", missionStatus=" + missionStatus +
        ", statusTtl=" + statusTtl +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}";

    }

}