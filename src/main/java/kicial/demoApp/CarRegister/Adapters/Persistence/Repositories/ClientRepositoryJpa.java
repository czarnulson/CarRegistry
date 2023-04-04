package kicial.demoApp.CarRegister.Adapters.Persistence.Repositories;

import jakarta.transaction.Transactional;
import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByUuid(UUID uuid);

    @Transactional
    void deleteByUuid(UUID uuid);
}
