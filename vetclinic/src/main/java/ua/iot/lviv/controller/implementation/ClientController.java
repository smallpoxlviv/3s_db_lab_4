package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Client;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.ClientService;

public class ClientController extends GeneralControllerImpl<Client> {
    private GeneralService<Client> clientService = new ClientService();

    @Override
    public GeneralService<Client> getService() {
        return clientService;
    }
}
