package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "team")
public class Team implements Serializable {
    /**
     * A serial was added
     */
    private static final long serialVersionUID = 4112956760199798147L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_functionality_id")
    private TeamFunctionality teamFunctionality;

    public Team() {}

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

    public TeamFunctionality getTeamFunctionality() {
        return teamFunctionality;
    }

    public void setTeamFunctionality(TeamFunctionality teamFunctionality) {
        this.teamFunctionality = teamFunctionality;
    }


    @Override
    public String toString() {
        return "Team {" +
        "id=" + id +
        ", name=" + name +
        ", teamFunctionality=" + teamFunctionality +
        "}";

    }

}