package kicial.demoApp.CarRegister.Domain.Ports;

import kicial.demoApp.CarRegister.Domain.Exceptions.RegistrationNumberUsedException;
import kicial.demoApp.CarRegister.Domain.Model.Car;

import java.util.List;

public interface CarServicePort {

    Car add(Car car) throws RegistrationNumberUsedException;

    List<Car> getAllByClientId(Long id);
}
