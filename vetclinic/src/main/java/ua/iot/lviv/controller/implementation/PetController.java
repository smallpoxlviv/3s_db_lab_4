package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Pet;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.PetService;

public class PetController extends GeneralControllerImpl<Pet> {
    private GeneralService<Pet> petService = new PetService();

    @Override
    public GeneralService<Pet> getService() {
        return petService;
    }
}
