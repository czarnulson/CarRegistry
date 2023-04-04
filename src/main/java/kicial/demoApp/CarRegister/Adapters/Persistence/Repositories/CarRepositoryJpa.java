package kicial.demoApp.CarRegister.Adapters.Persistence.Repositories;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepositoryJpa extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllByClientEntity_Uuid(UUID id);

    boolean existsByRegistrationNumber(String s);
}
