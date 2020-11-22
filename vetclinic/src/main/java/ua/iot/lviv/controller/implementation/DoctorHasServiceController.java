package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.DoctorHasService;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.DoctorHasServiceService;

public class DoctorHasServiceController extends GeneralControllerImpl<DoctorHasService> {
    private GeneralService<DoctorHasService> doctorHasServiceService = new DoctorHasServiceService();

    @Override
    public GeneralService<DoctorHasService> getService() {
        return doctorHasServiceService;
    }
}
