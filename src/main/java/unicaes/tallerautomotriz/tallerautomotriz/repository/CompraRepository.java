package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long> {

    @Query("SELECT p FROM CompraEntity p WHERE p.idPedido = :idPedido")
    List<CompraEntity> findIdCompra(@Param("idPedido") Long idPedido);

@Query("SELECT NEW unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO(" +
       "c.idPedido, c.descripcion, c.cantidad, c.fechaPedido) " +
       "FROM CompraEntity c " +
       "WHERE c.cantidad = :cantidad")
List<CompraDTO> findComprasPorCantidad(@Param("cantidad") Integer cantidad);

}
