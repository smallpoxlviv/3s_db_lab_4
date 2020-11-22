package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Doctor;

public class DoctorImpl implements Doctor {
    private Integer id;
    private String firstName;
    private String name;
    private String lastName;
    private Integer yearOfBirth;
    private String speciality;

    public DoctorImpl(Integer id, String firstName, String name, String lastName, Integer yearOfBirth, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.speciality = speciality;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String getSpeciality() {
        return speciality;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "DoctorImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
