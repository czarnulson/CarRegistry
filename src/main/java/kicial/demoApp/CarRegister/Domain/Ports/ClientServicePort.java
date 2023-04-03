package kicial.demoApp.CarRegister.Domain.Ports;

import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Model.Client;

import java.util.List;

public interface ClientServicePort {

    List<Client> getAll(int page);

    Client getById(Long id) throws ClientNotFoundException;

    Client add(Client client);

    Client update(Long id, Client updatedClient) throws ClientNotFoundException;

    void delete(Long id);
}
