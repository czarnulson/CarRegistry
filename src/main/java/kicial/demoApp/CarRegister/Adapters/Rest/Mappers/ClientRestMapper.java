package kicial.demoApp.CarRegister.Adapters.Rest.Mappers;

import kicial.demoApp.CarRegister.Adapters.Rest.DTO.ClientDTO;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientRestMapper {

    public ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());

        return clientDTO;
    }

    public Client toDomain(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());

        return client;
    }
}
