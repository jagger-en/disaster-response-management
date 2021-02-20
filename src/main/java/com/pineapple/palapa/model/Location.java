package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

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
    private String zipCode;
    private String centerCoordinate; // TODO: do we need to have geo coordinate type?

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCenterCoordinate() {
        return centerCoordinate;
    }

    public void setCenterCoordinate(String centerCoordinate) {
        this.centerCoordinate = centerCoordinate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Location {" +
        "id=" + id +
        ", name=" + name +
        ", zipCode=" + zipCode +
        ", centerCoordinate=" + centerCoordinate +
        ", city=" + city +
        "}";

    }

}