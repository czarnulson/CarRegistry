package kicial.demoApp.CarRegister.Adapters.Persistence.Mappers;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.CarEntity;
import kicial.demoApp.CarRegister.Domain.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarPersistentMapper {

    @Autowired
    ClientPersistenceMapper clientEntityMapper;

    public CarEntity toEntity(Car car) {
        return new CarEntity(
                car.getBrand(),
                car.getRegistrationNumber(),
                clientEntityMapper.toClientEntity(car.getClient())
        );
    }

    public Car toDomain(CarEntity car) {
        Car carDomain = new Car();
        carDomain.setId(car.getId());
        carDomain.setBrand(car.getBrand());
        carDomain.setRegistrationNumber(car.getRegistrationNumber());
        carDomain.setClient(clientEntityMapper.toDomain(car.getClientEntity()));

        return carDomain;
    }
}
