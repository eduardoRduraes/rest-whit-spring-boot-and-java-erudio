package br.com.erudio.restwhitspringbootandjavaerudio.model;

import jakarta.persistence.Entity;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionID = 1L;
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
