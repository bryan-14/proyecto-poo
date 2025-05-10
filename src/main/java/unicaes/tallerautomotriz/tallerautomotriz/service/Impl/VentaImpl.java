package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.VentaRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IVenta;

import java.util.List;

@Service
public class VentaImpl implements IVenta {

    //para leer
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<VentaEntity> findAll() {
        return ventaRepository.findAll();
    }
    //para escribir
    public VentaEntity save(VentaEntity ventaEntity) {
        return ventaRepository.save(ventaEntity);
    }

}
