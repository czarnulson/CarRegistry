package kicial.demoApp.CarRegister.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Long id;

    private String brand;

    private String registrationNumber;

    private Client client;
}
