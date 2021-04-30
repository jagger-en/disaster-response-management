package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vertice")
public class Vertice implements Serializable {

    /**
     * A serial was added
     */
    private static final long serialVersionUID = 1090L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private Point point;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


    public Vertice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Vertice {" +
        "id=" + id +
        ", point=" + point +
        ", location=" + location +
        "}";

    }

}