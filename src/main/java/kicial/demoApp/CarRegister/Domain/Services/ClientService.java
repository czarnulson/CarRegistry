package kicial.demoApp.CarRegister.Domain.Services;

import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import kicial.demoApp.CarRegister.Domain.Ports.ClientRepositoryPort;
import kicial.demoApp.CarRegister.Domain.Ports.ClientServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService implements ClientServicePort {

    @Autowired
    ClientRepositoryPort clientRepositoryPort;

    final int pageSize = 10;

    public List<Client> getAll(int page) {
        return clientRepositoryPort.getAll(page, pageSize);
    }

    public Client getById(UUID id) throws ClientNotFoundException {
        return clientRepositoryPort.getById(id).orElseThrow(ClientNotFoundException::new);
    }

    public Client add(Client client) {
        return clientRepositoryPort.add(client);
    }

    public Client update(UUID id, Client updatedClient) throws ClientNotFoundException {
        Client client = this.getById(id);

        client.setName(updatedClient.getName());
        client.setSurname(updatedClient.getSurname());

        return clientRepositoryPort.update(client);
    }

    public void delete(UUID id) {
        clientRepositoryPort.delete(id);
    }
}
