package kicial.demoApp.CarRegister.Domain.Services;

import kicial.demoApp.CarRegister.Domain.Exceptions.RegistrationNumberUsedException;
import kicial.demoApp.CarRegister.Domain.Model.Car;
import kicial.demoApp.CarRegister.Domain.Ports.CarRepositoryPort;
import kicial.demoApp.CarRegister.Domain.Ports.CarServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements CarServicePort {

    @Autowired
    CarRepositoryPort carRepositoryPort;

    public Car add(Car car) throws RegistrationNumberUsedException {
        if (carRepositoryPort.existsByRegistrationNumber(car.getRegistrationNumber())) {
            throw new RegistrationNumberUsedException();
        }

        return carRepositoryPort.add(car);
    }

    public List<Car> getAllByClientId(Long id) {
        return carRepositoryPort.getAllByClientEntityId(id);
    }
}
