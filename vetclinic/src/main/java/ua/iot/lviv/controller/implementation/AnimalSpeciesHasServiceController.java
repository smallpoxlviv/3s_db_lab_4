package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.AnimalSpeciesHasService;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.AnimalSpeciesHasServiceService;

public class AnimalSpeciesHasServiceController extends GeneralControllerImpl<AnimalSpeciesHasService> {
    private GeneralService<AnimalSpeciesHasService> animalSpeciesHasServiceService = new AnimalSpeciesHasServiceService();

    @Override
    public GeneralService<AnimalSpeciesHasService> getService() {
        return animalSpeciesHasServiceService;
    }
}
