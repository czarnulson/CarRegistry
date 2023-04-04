package kicial.demoApp.CarRegister.Domain.Ports;

import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientServicePort {

    List<Client> getAll(int page);

    Client getById(UUID id) throws ClientNotFoundException;

    Client add(Client client);

    Client update(UUID id, Client updatedClient) throws ClientNotFoundException;

    void delete(UUID id);
}
