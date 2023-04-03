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
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setRegistrationNumber(carDTO.getRegistrationNumber());
        car.setClient(clientService.getById(carDTO.getClientId()));

        return car;
    }

    public CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setClientId(car.getClient().getId());
        carDTO.setRegistrationNumber(car.getRegistrationNumber());

        return carDTO;
    }
}
