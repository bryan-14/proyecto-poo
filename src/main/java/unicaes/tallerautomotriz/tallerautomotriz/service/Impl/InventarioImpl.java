package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.InventarioEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.InventarioRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IInventario;

import java.util.List;

@Service

public class InventarioImpl implements IInventario {

    @Autowired
    private InventarioRepository inventarioRepository;
    @Override
    public List<InventarioEntity> findAll(){
        return inventarioRepository.findAll();
    }






}


