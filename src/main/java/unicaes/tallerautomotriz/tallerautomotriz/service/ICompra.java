package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;

import java.util.List;
import java.util.Optional;

public interface ICompra {
    
    //VER TODOS
    List<CompraEntity> findAll();
    //VER POR ID
    Optional<CompraEntity> findById(Long id);
    //MODIFICAR Y PONER
    CompraEntity save(CompraEntity compra);
    //ACTUALIZAR
    CompraEntity update(Long id, CompraEntity compra);
    //BORRAR
    void delete(Long id);
    //BUSCAR POR CANTIDAD
    List<CompraDTO> findComprasPorCantidad(Integer cantidad);
}
