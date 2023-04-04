package kicial.demoApp.CarRegister.Adapters.Rest.Controllers;

import jakarta.validation.Valid;
import kicial.demoApp.CarRegister.Adapters.Rest.DTO.CarDTO;
import kicial.demoApp.CarRegister.Adapters.Rest.Mappers.CarRestMapper;
import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Exceptions.RegistrationNumberUsedException;
import kicial.demoApp.CarRegister.Domain.Model.Car;
import kicial.demoApp.CarRegister.Domain.Services.CarService;
import kicial.demoApp.CarRegister.Domain.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRestMapper carRestMapper;

    @Autowired
    CarService carService;

    @Autowired
    ClientService clientService;

    @PostMapping("")
    public ResponseEntity<CarDTO> add(@Valid @RequestBody CarDTO carDTO) throws RegistrationNumberUsedException, ClientNotFoundException {
        Car car = carRestMapper.toDomain(carDTO);

        return new ResponseEntity<>(carRestMapper.toDTO(carService.add(car)), HttpStatus.CREATED);
    }

    @GetMapping("/{clientId}")
    public List<CarDTO> getAllByClientId(@Valid @PathVariable("clientId") String clientId) {

        return carService.getAllByClientId(UUID.fromString(clientId)).stream().map(carRestMapper::toDTO).toList();
    }
}
