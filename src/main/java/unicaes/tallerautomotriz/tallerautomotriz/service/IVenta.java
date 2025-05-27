package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.VentaDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;

import java.math.BigDecimal;
import java.util.List;

public interface IVenta {


    //para consultar
    List<VentaEntity>findAll();
    //para guardar
    VentaEntity save(VentaEntity compra);

    List<VentaEntity> findPriceLess(BigDecimal totalventa);

    List<VentaDto> ventaConIva();


}
