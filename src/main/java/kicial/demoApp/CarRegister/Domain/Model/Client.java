package kicial.demoApp.CarRegister.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long id;

    private String name;

    private String surname;
}
