package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;

import java.util.List;

public interface ICompra {
    //para consultar
    List<CompraEntity> findAll();
    //PARA GUARDAR
    CompraEntity save(CompraEntity pedidoRepuesto);

}
