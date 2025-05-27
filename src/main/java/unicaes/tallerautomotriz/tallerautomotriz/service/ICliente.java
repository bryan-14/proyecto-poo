package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;


import java.util.List;

public interface ICliente {

    //para consultar
    List<ClienteEntity> findAll();
    //para guardar
    ClienteEntity save(ClienteEntity cliente);

    //buscar por nombre
    List<ClienteEntity> findNameLess(String nombre);






}
