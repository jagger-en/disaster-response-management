package com.pineapple.palapa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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
    
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private String dateOfBirth;

    @OneToMany(mappedBy="person", cascade=CascadeType.REMOVE)
    Collection<Employee> employees;

    public Person() {}

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person {" +
        "id=" + id +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", gender=" + gender +
        ", dateOfBirth=" + dateOfBirth +
        "}";

    }

}