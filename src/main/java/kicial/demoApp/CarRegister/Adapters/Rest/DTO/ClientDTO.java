package kicial.demoApp.CarRegister.Adapters.Rest.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ClientDTO {
    private UUID uuid;

    @NotEmpty(message = "Name is required.")
    private String name;

    @NotEmpty(message = "Surname is required.")
    private String surname;
}
