package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;

import java.util.List;

public interface ICompra {
    //para consultar
    List<CompraEntity> findAll();

    List<CompraEntity> findIdCompra(Long idPedido);

    //PARA GUARDAR
    CompraEntity save(CompraDTO compraEntity);

    List<CompraDTO> findComprasByCantidad(Integer compraCantidad);
}
