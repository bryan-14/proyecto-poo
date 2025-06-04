package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ClienteDto;


import java.util.List;

public interface ICliente {

    //para consultar
    List<ClienteEntity> findAll();

    //para guardar
    ClienteEntity save(ClienteEntity cliente);

    List<ClienteDto> buscarClienteDto();

    //buscar por nombre
    List<ClienteEntity> findNameLess(String nombre);

    //eliminar clientes
    void deleteById(Long id);





}
