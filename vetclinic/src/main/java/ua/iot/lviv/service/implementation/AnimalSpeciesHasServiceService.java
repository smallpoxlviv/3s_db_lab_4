package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.AnimalSpeciesHasServiceDAO;
import ua.iot.lviv.model.AnimalSpeciesHasService;

public class AnimalSpeciesHasServiceService extends GeneralServiceImpl<AnimalSpeciesHasService> {
    private final GeneralDAO<AnimalSpeciesHasService, Integer> animalSpeciesHasServiceDAO = new AnimalSpeciesHasServiceDAO();

    @Override
    public GeneralDAO<AnimalSpeciesHasService, Integer> getDAO() {
        return animalSpeciesHasServiceDAO;
    }
}
