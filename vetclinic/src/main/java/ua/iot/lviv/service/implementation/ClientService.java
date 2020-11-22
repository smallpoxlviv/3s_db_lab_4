package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.ClientDAO;
import ua.iot.lviv.model.Client;


public class ClientService extends GeneralServiceImpl<Client> {
    private final GeneralDAO<Client, Integer> clientDAO = new ClientDAO();

    @Override
    public GeneralDAO<Client, Integer> getDAO() {
        return clientDAO;
    }
}
