package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "point")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getAllPoints",
                                procedureName = "get_all_points",
    resultClasses = Point.class)
})
public class Point implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 4112956760199798147L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String latitude;
    private String longitude;
    @OneToMany(mappedBy="point", cascade=CascadeType.REMOVE)
    Collection<Vertice> vertices;

    @OneToMany(mappedBy="point", cascade=CascadeType.REMOVE)
    Collection<SourcePoint> sourcePoints;

    @OneToMany(mappedBy="point", cascade=CascadeType.REMOVE)
    Collection<TerminalPoint> terminalPoints;

    @ManyToOne
    @JoinColumn(name = "point_type_id")
    private PointType pointType;

    public Point() {}

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public PointType getPointType() {
        return pointType;
    }

    public void setPointType(PointType pointType) {
        this.pointType = pointType;
    }

    @Override
    public String toString() {
        return "Point {" +
        "id=" + id +
        ", name=" + name +
        ", longitude=" + longitude +
        ", latitude=" + latitude +
        ", pointType=" + pointType +
        "}";

    }

}