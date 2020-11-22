package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.ClientHasPetDAO;
import ua.iot.lviv.model.ClientHasPet;


public class ClientHasPetService extends GeneralServiceImpl<ClientHasPet> {
    private final GeneralDAO<ClientHasPet, Integer> clientHasPetDAO = new ClientHasPetDAO();

    @Override
    public GeneralDAO<ClientHasPet, Integer> getDAO() {
        return clientHasPetDAO;
    }
}
