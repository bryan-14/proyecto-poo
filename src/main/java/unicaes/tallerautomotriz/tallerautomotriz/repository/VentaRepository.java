package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.VentaDto;

import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface VentaRepository extends JpaRepository<VentaEntity, Long> {

    @Query("SELECT p FROM VentaEntity p WHERE p.totalVenta = :totalventa")
    List<VentaEntity> findPriceLess(@Param("totalventa") BigDecimal totalventa);


    @Query("""
    SELECT new unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.VentaDto(p.idVenta, p.fechaVenta, p.totalVenta,
    Round((p.totalVenta * 0.13),2)) FROM VentaEntity p""")
    List<VentaDto> ventaConIva();

}
