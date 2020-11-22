package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.DiplomaDAO;
import ua.iot.lviv.model.Diploma;

public class DiplomaService extends GeneralServiceImpl<Diploma> {
    private final GeneralDAO<Diploma, Integer> diplomaDAO = new DiplomaDAO();

    @Override
    public GeneralDAO<Diploma, Integer> getDAO() {
        return diplomaDAO;
    }
}


