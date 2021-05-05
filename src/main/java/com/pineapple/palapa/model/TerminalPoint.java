package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "terminalPoint")
public class TerminalPoint implements Serializable {

    /**
     * A serial was added
     */
    private static final long serialVersionUID = 101200L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "point_id")
    private Point point;

    @OneToMany(mappedBy="terminalPoint", cascade=CascadeType.REMOVE)
    Collection<Adjacency> adjacencies;

    public TerminalPoint() {}

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

    @Override
    public String toString() {
        return "TerminalPoint {" +
        "id=" + id +
        ", point=" + point +
        "}";

    }

}