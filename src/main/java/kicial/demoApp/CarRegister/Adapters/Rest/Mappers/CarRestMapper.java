package kicial.demoApp.CarRegister.Adapters.Rest.Mappers;

import kicial.demoApp.CarRegister.Adapters.Rest.DTO.CarDTO;
import kicial.demoApp.CarRegister.Domain.Exceptions.ClientNotFoundException;
import kicial.demoApp.CarRegister.Domain.Model.Car;
import kicial.demoApp.CarRegister.Domain.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarRestMapper {

    @Autowired
    ClientService clientService;

    public Car toDomain(CarDTO carDTO) throws ClientNotFoundException {
        return Car.builder()
                .brand(carDTO.getBrand())
                .registrationNumber(carDTO.getRegistrationNumber())
                .client(clientService.getById(carDTO.getClientId()))
                .build();
    }

    public CarDTO toDTO(Car car) {
        return CarDTO.builder()
                .brand(car.getBrand())
                .clientId(car.getClient().getUuid())
                .registrationNumber(car.getRegistrationNumber())
                .build();
    }
}
