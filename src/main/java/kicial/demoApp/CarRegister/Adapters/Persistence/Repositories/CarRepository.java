package kicial.demoApp.CarRegister.Adapters.Persistence.Repositories;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.CarEntity;
import kicial.demoApp.CarRegister.Adapters.Persistence.Mappers.CarPersistentMapper;
import kicial.demoApp.CarRegister.Domain.Model.Car;
import kicial.demoApp.CarRegister.Domain.Ports.CarRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarRepository implements CarRepositoryPort {

    @Autowired
    CarRepositoryJpa carRepositoryJpa;

    @Autowired
    CarPersistentMapper carEntityMapper;

    @Override
    public Car add(Car car) {
        CarEntity carEntity = carRepositoryJpa.save(carEntityMapper.toEntity(car));

        return carEntityMapper.toDomain(carEntity);
    }

    @Override
    public List<Car> getAllByClientEntityId(Long id) {
        return carRepositoryJpa.findAllByClientEntity_Id(id).stream().map(carEntityMapper::toDomain).toList();
    }

    @Override
    public boolean existsByRegistrationNumber(String registrationNumber) {
        return carRepositoryJpa.existsByRegistrationNumber(registrationNumber);
    }
}
