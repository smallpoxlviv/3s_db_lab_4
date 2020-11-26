package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.PetDAO;
import ua.iot.lviv.model.Pet;

public class PetService extends GeneralServiceImpl<Pet> {
    private final GeneralDAO<Pet, Integer> petDAO = new PetDAO();

    @Override
    public GeneralDAO<Pet, Integer> getDAO() {
        return petDAO;
    }
}



