package kicial.demoApp.CarRegister.Domain.Ports;

import kicial.demoApp.CarRegister.Domain.Model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {

    List<Client> getAll(int page, int pageSize);

    Optional<Client> getById(Long id);

    Client add(Client client);

    Client update(Client client);

    void delete(Long id);
}
