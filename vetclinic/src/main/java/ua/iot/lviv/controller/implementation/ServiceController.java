package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Service;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.ServiceService;

public class ServiceController extends GeneralControllerImpl<Service> {
    private GeneralService<Service> serviceService = new ServiceService();

    @Override
    public GeneralService<Service> getService() {
        return serviceService;
    }
}
