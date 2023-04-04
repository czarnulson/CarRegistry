package Domain.Services;

import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import kicial.demoApp.CarRegister.Domain.Ports.ClientRepositoryPort;
import kicial.demoApp.CarRegister.Domain.Services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ClientService.class, ClientRepositoryPort.class})
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepositoryPort clientRepositoryPort;

    @Test
    public void shouldReturnAllClients() {
        // given
        List<Client> clientsExpected = Arrays.asList(
                new Client(UUID.randomUUID(), "Sheldon", "Cooper"),
                new Client(UUID.randomUUID(), "Leonard", "Hofstadter")
        );

        when(clientRepositoryPort.getAll(1,10)).thenReturn(clientsExpected);

        // when
        List<Client> clients = clientService.getAll(1);

        // then
        assertEquals(clientsExpected.size(), clients.size());
    }

    @Test
    public void shouldGetClientById() throws ClientNotFoundException {
        // given
        UUID clientId = UUID.randomUUID();

        Client clientExpected = new Client(clientId, "Sheldon", "Cooper");

        when(clientRepositoryPort.getById(clientId)).thenReturn(Optional.of(clientExpected));

        // when
        Client clientResult = clientService.getById(clientId);

        // then
        assertNotNull(clientResult);
        assertEquals(clientExpected.getUuid(), clientResult.getUuid());
        assertEquals(clientExpected.getName(), clientResult.getName());
        assertEquals(clientExpected.getSurname(), clientResult.getSurname());
    }

    @Test
    public void shouldThrowClientNotFoundExceptionWhenGetClientById() {
        // given
        UUID clientId = UUID.randomUUID();

        when(clientRepositoryPort.getById(clientId)).thenReturn(Optional.empty());

        // when & then
        assertThrows(ClientNotFoundException.class, () -> clientService.getById(clientId));
    }

    @Test
    public void shouldAddClient() {
        // given
        Client client = new Client(UUID.randomUUID(), "Sheldon", "Cooper");

        when(clientRepositoryPort.add(client)).thenReturn(client);

        // when
        Client clientResult = clientService.add(client);

        // then
        assertNotNull(clientResult);
        assertEquals(client.getUuid(), clientResult.getUuid());
        assertEquals(client.getName(), clientResult.getName());
        assertEquals(client.getSurname(), clientResult.getSurname());
    }

    @Test
    public void shouldUpdateClient() throws ClientNotFoundException {
        // given
        UUID clientId = UUID.randomUUID();

        Client clientExpected = new Client(clientId, "Sheldon", "Cooper");
        Client clientUpdated = Client.builder().name("Leonard").surname("Hofstadter").build();

        when(clientRepositoryPort.getById(clientId)).thenReturn(Optional.of(clientExpected));
        when(clientRepositoryPort.update(clientExpected)).thenReturn(clientExpected);

        // when
        Client clientResult = clientService.update(clientId, clientUpdated);

        // then
        assertNotNull(clientResult);
        assertEquals(clientResult.getUuid(), clientId);
        assertEquals(clientResult.getName(), clientUpdated.getName());
        assertEquals(clientResult.getSurname(), clientUpdated.getSurname());

        verify(clientRepositoryPort, times(1)).getById(clientId);
        verify(clientRepositoryPort, times(1)).update(clientExpected);
    }

    @Test
    public void willThrowClientNotFoundExceptionWhenUpdatingClient() {
        // given
        UUID clientId = UUID.randomUUID();

        Client clientExpected = new Client(clientId, "Sheldon", "Cooper");
        Client clientUpdated = Client.builder().name("Leonard").surname("Hofstadter").build();

        when(clientRepositoryPort.getById(clientId)).thenReturn(Optional.empty());

        // when & then
        assertThrows(ClientNotFoundException.class, () -> clientService.update(clientId, clientUpdated));

        verify(clientRepositoryPort, times(1)).getById(clientId);
        verify(clientRepositoryPort, times(0)).update(clientExpected);
    }

    @Test
    public void shouldDeleteClient() {
        // given
        UUID clientId = UUID.randomUUID();

        // when
        clientService.delete(clientId);

        // then
        verify(clientRepositoryPort).delete(clientId);
    }
}
