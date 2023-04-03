package kicial.demoApp.CarRegister.Adapters.Persistence.Repositories;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.ClientEntity;
import kicial.demoApp.CarRegister.Adapters.Persistence.Mappers.ClientPersistenceMapper;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import kicial.demoApp.CarRegister.Domain.Ports.ClientRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements ClientRepositoryPort{

    @Autowired
    ClientRepositoryJpa clientRepositoryJpa;

    @Autowired
    ClientPersistenceMapper clientPersistenceMapper;

    @Override
    public List<Client> getAll(int page, int pageSize) {
        Pageable paging = PageRequest.of(page - 1, pageSize);
        return clientRepositoryJpa.findAll(paging).stream().map(clientPersistenceMapper::toDomain).toList();
    }

    @Override
    public Optional<Client> getById(Long id) {
        return clientRepositoryJpa.findById(id).map(clientPersistenceMapper::toDomain);
    }

    @Override
    public Client add(Client client) {
        ClientEntity clientEntity = clientRepositoryJpa.save(clientPersistenceMapper.toClientEntity(client));

        return clientPersistenceMapper.toDomain(clientEntity);
    }

    @Override
    public Client update(Client client) {
        return this.add(client);
    }

    @Override
    public void delete(Long id) {
        clientRepositoryJpa.deleteById(id);
    }
}
