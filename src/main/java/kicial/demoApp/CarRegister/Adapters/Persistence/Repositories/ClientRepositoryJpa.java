package kicial.demoApp.CarRegister.Adapters.Persistence.Repositories;

import kicial.demoApp.CarRegister.Adapters.Persistence.Entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {

}
