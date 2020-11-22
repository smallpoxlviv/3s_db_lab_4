package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Diploma;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.DiplomaService;

public class DiplomaController extends GeneralControllerImpl<Diploma> {
    private GeneralService<Diploma> diplomaService = new DiplomaService();

    @Override
    public GeneralService<Diploma> getService() {
        return diplomaService;
    }
}
