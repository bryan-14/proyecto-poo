package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long> {

    @Query("SELECT p FROM CompraEntity p WHERE p.idPedido = :idPedido")
    List<CompraEntity> findIdCompra(@Param("idPedido") Long idPedido);

}
