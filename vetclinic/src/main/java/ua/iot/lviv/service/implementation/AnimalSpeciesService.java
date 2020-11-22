package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.AnimalSpeciesDAO;
import ua.iot.lviv.model.AnimalSpecies;


public class AnimalSpeciesService extends GeneralServiceImpl<AnimalSpecies> {
    private final GeneralDAO<AnimalSpecies, Integer> animalSpeciesDAO = new AnimalSpeciesDAO();

    @Override
    public GeneralDAO<AnimalSpecies, Integer> getDAO() {
        return animalSpeciesDAO;
    }
}
