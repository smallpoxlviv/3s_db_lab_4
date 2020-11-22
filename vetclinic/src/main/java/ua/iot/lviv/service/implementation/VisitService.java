package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.VisitDAO;
import ua.iot.lviv.model.Visit;

public class VisitService extends GeneralServiceImpl<Visit> {
    private final GeneralDAO<Visit, Integer> visitDAO = new VisitDAO();

    @Override
    public GeneralDAO<Visit, Integer> getDAO() {
        return visitDAO;
    }
}


