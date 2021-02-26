package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "city")
public class City implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 4112956760199798147L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String centerCoordinate; // TODO: do we need to have geo coordinate type?
    @OneToMany(mappedBy="city", cascade=CascadeType.REMOVE)
    Collection<Location> locations;

    public City() {}

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

    public String getCenterCoordinate() {
        return centerCoordinate;
    }

    public void setCenterCoordinate(String centerCoordinate) {
        this.centerCoordinate = centerCoordinate;
    }

    @Override
    public String toString() {
        return "City {" +
        "id=" + id +
        ", name=" + name +
        ", centerCoordinate=" + centerCoordinate +
        "}";

    }

}