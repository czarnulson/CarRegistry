package kicial.demoApp.CarRegister.Adapters.Rest.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarDTO {

    @NotNull
    private Long clientId;

    @NotEmpty(message = "Brand is required.")
    private String brand;

    @NotEmpty(message = "Registration number is required.")
    private String registrationNumber;
}
