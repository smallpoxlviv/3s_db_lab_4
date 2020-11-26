package ua.iot.lviv.model;

import java.time.LocalDate;

public interface Pet extends GeneralModel {
    Integer getAnimalSpeciesId();
    void setAnimalSpeciesId(Integer id);
    String getName();
    void setName(String name);
    Integer getWeightInKg();
    void setWeightInKg(Integer weightInKg);
    Integer getLengthInCm();
    void setLengthInCm(Integer lengthInCm);
    LocalDate getDateOfBirth();
    void setDateOfBirth(LocalDate dateOfBirth);
}
