package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 1002L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private String latitude;
    private String longitude;

    @OneToMany(mappedBy="location", cascade=CascadeType.REMOVE)
    Collection<MissionAndLocation> missionAndLocations;

    @OneToMany(mappedBy="location", cascade=CascadeType.REMOVE)
    Collection<Employee> employees;

    public Location() {}

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location {" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        "}";
    }
}
