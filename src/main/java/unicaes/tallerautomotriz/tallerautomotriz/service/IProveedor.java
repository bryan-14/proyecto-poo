package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;

import java.util.List;

public interface IProveedor {

    //VER TODOS
    List<ProveedorDto> findAll();

    //VER POR ID
    ProveedorDto findById(Long id);

    //MODIFICAR Y PONER
    ProveedorEntity save(ProveedorEntity proveedor);

    //BORRAR
    void delete(Long id);

   //BUSCAR POR
    List<ProveedorDto> findByNombre(String nombre);
}
