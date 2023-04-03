package kicial.demoApp.CarRegister.Adapters.Persistence.Mappers;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.ClientEntity;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientPersistenceMapper {

    public ClientEntity toClientEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setName(client.getName());
        clientEntity.setSurname(client.getSurname());

        return clientEntity;
    }

    public Client toDomain(ClientEntity clientEntity) {
        Client client = new Client();
        client.setId(clientEntity.getId());
        client.setName(clientEntity.getName());
        client.setSurname(clientEntity.getSurname());

        return client;
    }
}
