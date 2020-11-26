package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.AnimalSpeciesHasService;

public class AnimalSpeciesHasServiceImpl implements AnimalSpeciesHasService {
    private Integer id;
    private Integer AnimalSpeciesId;
    private Integer ServiceId;

    public AnimalSpeciesHasServiceImpl(Integer id, Integer AnimalSpeciesId, Integer ServiceId){
        this.id = id;
        this.AnimalSpeciesId = AnimalSpeciesId;
        this.ServiceId = ServiceId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getAnimalSpeciesId() {
        return this.AnimalSpeciesId;
    }

    public void setAnimalSpeciesId(Integer AnimalSpeciesId) {
        this.AnimalSpeciesId = AnimalSpeciesId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return this.ServiceId;
    }

    public void setServiceId(Integer serviceId) {
        this.ServiceId = serviceId;
    }

    @Override
    public String toString() {
        return "AnimalSpeciesHasServiceImpl{" +
                "id=" + id +
                ", AnimalSpeciesId=" + AnimalSpeciesId +
                ", ServiceId=" + ServiceId +
                '}';
    }
}
