package br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOV2 implements Serializable {
    private static final long serialVersionID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private Date birthDate;
    private String gender;

    public PersonVOV2() {

    }

    public PersonVOV2(String firstName, String lastName, String address, String gender, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVOV2 that = (PersonVOV2) o;
        return id.equals(that.id) && firstName.equals(that.firstName) && lastName.equals(that.lastName) && address.equals(that.address) && birthDate.equals(that.birthDate) && gender.equals(that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, birthDate, gender);
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
