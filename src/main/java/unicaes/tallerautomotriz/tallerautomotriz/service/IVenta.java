package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;

import java.util.List;

public interface IVenta {
    //para consultar
    List<VentaEntity>findAll();
    //para guardar
    VentaEntity save(VentaEntity compra);
}
