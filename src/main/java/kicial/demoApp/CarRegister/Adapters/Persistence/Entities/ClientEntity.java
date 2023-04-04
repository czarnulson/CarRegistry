package kicial.demoApp.CarRegister.Adapters.Persistence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "clientEntity", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<CarEntity> cars = new ArrayList<>();
}
