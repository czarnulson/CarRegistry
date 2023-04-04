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
        return CarEntity.builder()
                .uuid(car.getUuid())
                .brand(car.getBrand())
                .registrationNumber(car.getRegistrationNumber())
                .clientEntity(clientEntityMapper.toClientEntity(car.getClient()))
                .build();
    }

    public Car toDomain(CarEntity car) {
        return Car.builder()
                .uuid(car.getUuid())
                .brand(car.getBrand())
                .registrationNumber(car.getRegistrationNumber())
                .client(clientEntityMapper.toDomain(car.getClientEntity()))
                .build();
    }
}
