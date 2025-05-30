package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.VentaDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;

import java.math.BigDecimal;
import java.util.List;

public interface IVenta {


    //para consultar
    List<VentaEntity>findAll();

    List<VentaEntity> findId(Long idVenta);

    List<VentaDto> ventaConIva();

    //para guardar
    VentaEntity save(VentaEntity compra);

}
