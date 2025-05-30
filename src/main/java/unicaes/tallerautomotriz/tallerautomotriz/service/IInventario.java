package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.InventarioEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.InventarioDTO;

import java.util.List;

public interface IInventario {

    List<InventarioEntity>findAll();
    List<InventarioEntity> findByName(String nombre);
    List<InventarioDTO> findByNameAsDTO(String nombre);
    InventarioEntity save(InventarioEntity inventario);
    void delete(Long idInventario);

}