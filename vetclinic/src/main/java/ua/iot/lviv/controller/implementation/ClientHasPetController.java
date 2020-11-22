package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.ClientHasPet;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.ClientHasPetService;

public class ClientHasPetController extends GeneralControllerImpl<ClientHasPet> {
    private GeneralService<ClientHasPet> clientHasPetService = new ClientHasPetService();

    @Override
    public GeneralService<ClientHasPet> getService() {
        return clientHasPetService;
    }
}
