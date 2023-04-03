package kicial.demoApp.CarRegister.Adapters.Persistence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {

    public CarEntity(String brand, String registrationNumber, ClientEntity clientEntity) {
        this.brand = brand;
        this.registrationNumber = registrationNumber;
        this.clientEntity = clientEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity clientEntity;

    private String brand;

    private String registrationNumber;
}
