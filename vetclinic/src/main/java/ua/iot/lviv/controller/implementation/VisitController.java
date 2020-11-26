package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Visit;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.VisitService;

public class VisitController extends GeneralControllerImpl<Visit> {
    private GeneralService<Visit> visitService = new VisitService();

    @Override
    public GeneralService<Visit> getService() {
        return visitService;
    }
}
