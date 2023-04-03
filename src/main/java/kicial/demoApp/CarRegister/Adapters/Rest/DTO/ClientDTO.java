package kicial.demoApp.CarRegister.Adapters.Rest.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClientDTO {
    @NotEmpty(message = "Name is required.")
    private String name;

    @NotEmpty(message = "Surname is required.")
    private String surname;
}
