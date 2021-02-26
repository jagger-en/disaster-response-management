package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "mission_type_id")
    private MissionType missionType;

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "location_type_id")
    private Location location;

    private String startTime;
    private String endTime;

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

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType missionType) {
        this.missionType = missionType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
        ", missionType=" + missionType +
        ", location=" + location +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}";

    }

}