package ua.iot.lviv.controller.implementation;


import ua.iot.lviv.model.AnimalSpecies;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.AnimalSpeciesService;

public class AnimalSpeciesController extends GeneralControllerImpl<AnimalSpecies> {
    private GeneralService<AnimalSpecies> animalSpeciesService = new AnimalSpeciesService();

    @Override
    public GeneralService<AnimalSpecies> getService() {
        return animalSpeciesService;
    }
}
