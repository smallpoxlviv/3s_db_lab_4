package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Diagnosis;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.DiagnosisService;

public class DiagnosisController extends GeneralControllerImpl<Diagnosis> {
    private GeneralService<Diagnosis> diagnosisService = new DiagnosisService();

    @Override
    public GeneralService<Diagnosis> getService() {
        return diagnosisService;
    }
}
