package kicial.demoApp.CarRegister.Domain.Model;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    private String name;

    private String surname;
}
