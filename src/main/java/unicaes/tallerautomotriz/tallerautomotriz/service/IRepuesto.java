package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity;

import java.util.List;

public interface IRepuesto {
    //para consultar
    List<RepuestoEntity> findAll();

    //para guardar
    RepuestoEntity save(RepuestoEntity repuesto);

}
