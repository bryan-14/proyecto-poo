package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;

import java.util.List;
import java.util.Optional;

public interface IProveedor {

    //VER TODOS
    List<ProveedorEntity> findAll();

    //VER POR ID
    Optional<ProveedorEntity> findById(Long id);

    //MODIFICAR Y PONER
    ProveedorEntity save(ProveedorEntity proveedor);

    //ACTUALIZAR
    ProveedorEntity update(Long id, ProveedorEntity proveedor);

    //BORRAR
    void delete(Long id);

   //BUSCAR POR
    List<ProveedorDto> findByNombre(String nombre);
}
