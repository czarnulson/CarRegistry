package kicial.demoApp.CarRegister.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Car {

    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    private String brand;

    private String registrationNumber;

    private Client client;
}
