package kicial.demoApp.CarRegister.Adapters.Persistence.Mappers;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.ClientEntity;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientPersistenceMapper {

    public ClientEntity toClientEntity(Client client) {
        return ClientEntity.builder()
                .uuid(client.getUuid())
                .name(client.getName())
                .surname(client.getSurname())
                .build();
    }

    public Client toDomain(ClientEntity clientEntity) {
        return Client.builder()
                .uuid(clientEntity.getUuid())
                .name(clientEntity.getName())
                .surname(clientEntity.getSurname())
                .build();
    }
}
