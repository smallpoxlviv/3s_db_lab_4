package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Doctor;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.DoctorService;

public class DoctorController extends GeneralControllerImpl<Doctor> {
    private GeneralService<Doctor> doctorService = new DoctorService();

    @Override
    public GeneralService<Doctor> getService() {
        return doctorService;
    }
}
