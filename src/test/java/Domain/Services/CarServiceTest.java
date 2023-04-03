package Domain.Services;

import kicial.demoApp.CarRegister.Domain.Exceptions.RegistrationNumberUsedException;
import kicial.demoApp.CarRegister.Domain.Model.Car;
import kicial.demoApp.CarRegister.Domain.Model.Client;
import kicial.demoApp.CarRegister.Domain.Ports.CarRepositoryPort;
import kicial.demoApp.CarRegister.Domain.Services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {CarService.class, CarRepositoryPort.class})
public class CarServiceTest {

    @Autowired
    CarService carService;

    @MockBean
    CarRepositoryPort carRepositoryPort;

    @Test
    public void shouldReturnListOfCars() {
        // given
        Long clientId = 1L;
        List<Car> carsExpected = Arrays.asList(
                new Car(1L, "Toyota", "GD1234A", new Client()),
                new Car(2L, "Honda", "GD1234B", new Client())
        );

        when(carRepositoryPort.getAllByClientEntityId(clientId)).thenReturn(carsExpected);

        // when
        List<Car> carsReceived = carService.getAllByClientId(clientId);

        // then
        assertEquals(carsExpected.size(), carsReceived.size());
    }

    @Test
    public void shouldAddCar() throws RegistrationNumberUsedException {
        // given
        Car car = new Car(1L, "Toyota", "GD1234A", new Client());

        when(carRepositoryPort.existsByRegistrationNumber(car.getRegistrationNumber())).thenReturn(false);
        when(carRepositoryPort.add(car)).thenReturn(car);

        // when
        Car result = carService.add(car);

        // then
        assertNotNull(result);
        assertEquals(car.getId(), result.getId());
        assertEquals(car.getBrand(), result.getBrand());
        assertEquals(car.getRegistrationNumber(), result.getRegistrationNumber());
        assertEquals(car.getClient(), result.getClient());

        verify(carRepositoryPort, times(1)).existsByRegistrationNumber(car.getRegistrationNumber());
        verify(carRepositoryPort, times(1)).add(car);
    }

    @Test
    public void addShouldThrowRegistrationNumberUsedException() {
        // given
        Car car = new Car(1L, "Toyota", "GD1234A", new Client());

        when(carRepositoryPort.existsByRegistrationNumber(car.getRegistrationNumber())).thenReturn(true);

        // when & then
        assertThrows(RegistrationNumberUsedException.class, () -> carService.add(car));

        verify(carRepositoryPort, times(1)).existsByRegistrationNumber(car.getRegistrationNumber());
        verify(carRepositoryPort, times(0)).add(car);
    }
}
