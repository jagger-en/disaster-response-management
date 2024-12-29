package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "missionStatus")
public class MissionStatus implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 415676435199798147L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String background;
    private String description;

    @OneToMany(mappedBy="missionStatus", cascade=CascadeType.REMOVE)
    Collection<Mission> missions;

    public MissionStatus() {}

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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "MissionStatus {" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        "}";

    }

}