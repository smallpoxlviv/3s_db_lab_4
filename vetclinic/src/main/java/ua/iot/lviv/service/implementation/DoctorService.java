package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.DoctorDAO;
import ua.iot.lviv.model.Doctor;

public class DoctorService extends GeneralServiceImpl<Doctor> {
    private final GeneralDAO<Doctor, Integer> doctorDAO = new DoctorDAO();

    @Override
    public GeneralDAO<Doctor, Integer> getDAO() {
        return doctorDAO;
    }
}


