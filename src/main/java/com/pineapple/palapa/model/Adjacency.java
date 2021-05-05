package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adjacency")
public class Adjacency implements Serializable {

    /**
     * A serial was added
     */
    private static final long serialVersionUID = 101200L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "source_point_id")
    private SourcePoint sourcePoint;
    @ManyToOne
    @JoinColumn(name = "terminal_point_id")
    private TerminalPoint terminalPoint;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Adjacency() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SourcePoint getSourcePoint() {
        return sourcePoint;
    }

    public void setSourcePoint(SourcePoint sourcePoint) {
        this.sourcePoint = sourcePoint;
    }

    public TerminalPoint getTerminalPoint() {
        return terminalPoint;
    }

    public void setTerminalPoint(TerminalPoint terminalPoint) {
        this.terminalPoint = terminalPoint;
    }

    public Location getlocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Adjacency {" +
        "id=" + id +
        ", sourcePoint=" + sourcePoint +
        ", terminalPoint=" + terminalPoint +
        ", location=" + location +
        "}";

    }

}