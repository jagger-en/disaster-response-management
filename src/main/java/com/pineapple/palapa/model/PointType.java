package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "pointType")
public class PointType implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 115235435199798147L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy="pointType", cascade=CascadeType.REMOVE)
    Collection<Point> points;

    public PointType() {}

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


    @Override
    public String toString() {
        return "PointType {" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        "}";

    }

}