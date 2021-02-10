package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    /**
     * A serial was added
     */
    private static final long serialVersionUID = 1000L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    
    private Date dateOfBirth; // TODO: confirm whether this is the correct format
    
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender; // TODO: add Gender table

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location; // TODO: add Location table

    public Person() {}

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Team {" +
        "id=" + id +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", dateOfBirth=" + dateOfBirth +
        ", gender=" + gender +
        ", location=" + location +
        "}";

    }

}