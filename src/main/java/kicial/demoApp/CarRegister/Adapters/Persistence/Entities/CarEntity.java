package kicial.demoApp.CarRegister.Adapters.Persistence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarEntity {

    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name="client_uuid")
    private ClientEntity clientEntity;

    private String brand;

    private String registrationNumber;

    public void setUuid(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }
}
