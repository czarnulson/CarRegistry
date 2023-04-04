package kicial.demoApp.CarRegister.Adapters.Rest.Mappers;

import kicial.demoApp.CarRegister.Adapters.Rest.DTO.ClientDTO;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientRestMapper {

    public ClientDTO toDTO(Client client) {
        return ClientDTO.builder()
                .uuid(client.getUuid())
                .name(client.getName())
                .surname(client.getSurname())
                .build();
    }

    public Client toDomain(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.getName())
                .surname(clientDTO.getSurname())
                .build();
    }
}
