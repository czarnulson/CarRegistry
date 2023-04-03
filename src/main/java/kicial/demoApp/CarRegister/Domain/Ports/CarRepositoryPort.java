package kicial.demoApp.CarRegister.Domain.Ports;

import kicial.demoApp.CarRegister.Domain.Model.Car;

import java.util.List;

public interface CarRepositoryPort {

    Car add(Car car);

    List<Car> getAllByClientEntityId(Long id);

    boolean existsByRegistrationNumber(String registrationNumber);
}
