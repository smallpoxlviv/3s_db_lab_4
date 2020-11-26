package ua.iot.lviv.model;

public interface Doctor extends GeneralModel {
    String getFirstName();
    void setFirstName(String firstName);
    String getName();
    void setName(String name);
    String getLastName();
    void setLastName(String lastName);
    Integer getYearOfBirth();
    void setYearOfBirth(Integer yearOfBirth);
    String getSpeciality();
    void setSpeciality(String speciality);
}
