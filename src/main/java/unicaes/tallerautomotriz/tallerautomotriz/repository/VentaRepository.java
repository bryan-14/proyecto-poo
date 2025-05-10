package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;

@Repository

public interface VentaRepository extends JpaRepository<VentaEntity, Long> {

}
