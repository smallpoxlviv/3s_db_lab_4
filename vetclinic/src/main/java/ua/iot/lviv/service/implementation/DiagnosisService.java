package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.DiagnosisDAO;
import ua.iot.lviv.model.Diagnosis;

public class DiagnosisService extends GeneralServiceImpl<Diagnosis> {
    private final GeneralDAO<Diagnosis, Integer> diagnosisDAO = new DiagnosisDAO();

    @Override
    public GeneralDAO<Diagnosis, Integer> getDAO() {
        return diagnosisDAO;
    }
}

