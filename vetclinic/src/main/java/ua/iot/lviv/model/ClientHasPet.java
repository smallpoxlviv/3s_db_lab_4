package ua.iot.lviv.model;

public interface ClientHasPet extends GeneralModel {
    Integer getClientId();
    void setClientId(Integer clientId);
    Integer getPetId();
    void setPetId(Integer petId);
}
