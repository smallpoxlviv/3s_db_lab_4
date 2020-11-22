package ua.iot.lviv.model;

public interface Client extends GeneralModel {
    String getFirstName();
    void setFirstName(String firstName);
    String getName();
    void setName(String name);
    String getLastName();
    void setLastName(String lastName);
}
