package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.AnimalSpecies;


public class AnimalSpeciesImpl implements AnimalSpecies {
    private Integer id;
    private String species;

    public AnimalSpeciesImpl(Integer id, String species){
        this.id = id;
        this.species = species;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnimalSpeciesImpl{" +
                "id=" + id +
                ", species='" + species + '\'' +
                '}';
    }
}
