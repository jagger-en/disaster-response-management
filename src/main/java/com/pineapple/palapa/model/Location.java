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

    @OneToMany(mappedBy="location", cascade=CascadeType.REMOVE)
    Collection<Mission> missions;

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


    @Override
    public String toString() {
        return "Location {" +
        "id=" + id +
        ", name=" + name +
        "}";

    }

}