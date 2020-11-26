package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.DoctorHasServiceDAO;
import ua.iot.lviv.model.DoctorHasService;

public class DoctorHasServiceService extends GeneralServiceImpl<DoctorHasService> {
    private final GeneralDAO<DoctorHasService, Integer> doctorHasServiceDAO = new DoctorHasServiceDAO();

    @Override
    public GeneralDAO<DoctorHasService, Integer> getDAO() {
        return doctorHasServiceDAO;
    }
}


