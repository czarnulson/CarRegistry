package kicial.demoApp.CarRegister.Adapters.Rest.Controllers;

import kicial.demoApp.CarRegister.Adapters.Rest.DTO.ClientDTO;
import kicial.demoApp.CarRegister.Adapters.Rest.Mappers.ClientRestMapper;
import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import kicial.demoApp.CarRegister.Domain.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRestMapper clientRestMapper;

    @GetMapping("")
    public List<ClientDTO> getAll(@RequestParam(name = "page", defaultValue = "1") int page) {
        return clientService.getAll(page).stream().map(clientRestMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable("id") Long id) throws ClientNotFoundException {
        return clientRestMapper.toDTO(clientService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<ClientDTO> add(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.add(clientRestMapper.toDomain(clientDTO));

        return new ResponseEntity<>(clientRestMapper.toDTO(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO) throws ClientNotFoundException {
        Client client = clientService.update(id, clientRestMapper.toDomain(clientDTO));

        return clientRestMapper.toDTO(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        clientService.delete(id);
    }
}
