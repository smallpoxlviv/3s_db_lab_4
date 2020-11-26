package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.ServiceDAO;
import ua.iot.lviv.model.Service;

public class ServiceService extends GeneralServiceImpl<Service> {
    private final GeneralDAO<Service, Integer> serviceDAO = new ServiceDAO();

    @Override
    public GeneralDAO<Service, Integer> getDAO() {
        return serviceDAO;
    }
}


