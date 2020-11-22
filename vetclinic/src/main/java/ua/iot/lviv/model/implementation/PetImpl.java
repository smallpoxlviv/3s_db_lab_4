package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Pet;

import java.time.LocalDate;
import java.util.Date;

public class PetImpl implements Pet {
    private Integer id;
    private Integer animalSpeciesId;
    private String name;
    private Integer weightInKg;
    private Integer lengthInCm;
    private LocalDate dateOfBirth;

    public PetImpl(Integer id, Integer animalSpeciesId, String name, Integer weightInKg, Integer lengthInCm, LocalDate dateOfBirth) {
        this.id = id;
        this.animalSpeciesId = animalSpeciesId;
        this.name = name;
        this.weightInKg = weightInKg;
        this.lengthInCm = lengthInCm;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getAnimalSpeciesId() {
        return animalSpeciesId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getWeightInKg() {
        return weightInKg;
    }

    @Override
    public Integer getLengthInCm() {
        return lengthInCm;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setAnimalSpeciesId(Integer animalSpeciesId) {
        this.animalSpeciesId = animalSpeciesId;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeightInKg(Integer weightInKg) {
        this.weightInKg = weightInKg;
    }

    @Override
    public void setLengthInCm(Integer lengthInCm) {
        this.lengthInCm = lengthInCm;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "PetImpl{" +
                "id=" + id +
                ", animalSpeciesId=" + animalSpeciesId +
                ", name='" + name + '\'' +
                ", weightInKg=" + weightInKg +
                ", lengthInCm=" + lengthInCm +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
