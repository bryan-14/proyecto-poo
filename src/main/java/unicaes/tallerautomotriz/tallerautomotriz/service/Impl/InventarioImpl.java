package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.InventarioEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.InventarioDTO;
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

    @Override
    public List<InventarioEntity> findByName(String nombre) {
        return inventarioRepository.findByName(nombre);
    }

     @Override
    public List<InventarioDTO> findByNameAsDTO(String nombre) {
        return inventarioRepository.findByNameAsDTO(nombre);
    }

    @Override
    public void delete(Long idInventario) {
        inventarioRepository.deleteById(idInventario);
    }

    @Override
    public InventarioEntity save(InventarioEntity inventario) {
        return inventarioRepository.save(inventario);
    }
}