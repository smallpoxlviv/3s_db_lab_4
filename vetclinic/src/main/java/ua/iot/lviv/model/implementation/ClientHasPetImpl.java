package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.ClientHasPet;

public class ClientHasPetImpl implements ClientHasPet {
    private Integer id;
    private Integer clientId;
    private Integer petId;

    public ClientHasPetImpl(Integer id, Integer clientId, Integer petId) {
        this.id = id;
        this.clientId = clientId;
        this.petId = petId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getClientId() {
        return clientId;
    }

    @Override
    public Integer getPetId() {
        return petId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "ClientHasPetImpl{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", petId=" + petId +
                '}';
    }
}
