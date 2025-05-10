package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;

@Repository

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {




}
