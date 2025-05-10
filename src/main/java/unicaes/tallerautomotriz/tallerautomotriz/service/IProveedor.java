package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;

import java.util.List;

public interface IProveedor {

    //para consulta
    List<ProveedorEntity> findAll();

    //para escribir
    ProveedorEntity save(ProveedorEntity proveedor);
}
