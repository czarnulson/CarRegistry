package kicial.demoApp.CarRegister.Adapters.Rest.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CarDTO {

    @NotNull
    private UUID clientId;

    @NotEmpty(message = "Brand is required.")
    private String brand;

    @NotEmpty(message = "Registration number is required.")
    private String registrationNumber;
}
