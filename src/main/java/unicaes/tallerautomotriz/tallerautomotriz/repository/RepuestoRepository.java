package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity;

import java.util.List;

public interface RepuestoRepository extends JpaRepository<RepuestoEntity, Long> {

    @Query("SELECT r FROM RepuestoEntity r WHERE r.categoria = :categoria")
    List<RepuestoEntity> findByCategoria(@Param("categoria") String categoria);
}
