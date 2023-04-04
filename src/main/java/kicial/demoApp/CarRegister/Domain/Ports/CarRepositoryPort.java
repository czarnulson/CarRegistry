package kicial.demoApp.CarRegister.Domain.Ports;

import kicial.demoApp.CarRegister.Domain.Model.Car;

import java.util.List;
import java.util.UUID;

public interface CarRepositoryPort {

    Car add(Car car);

    List<Car> getAllByClientEntityId(UUID id);

    boolean existsByRegistrationNumber(String registrationNumber);
}
