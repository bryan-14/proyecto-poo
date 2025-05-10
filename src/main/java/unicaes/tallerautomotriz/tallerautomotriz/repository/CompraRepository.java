package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long> {

}
