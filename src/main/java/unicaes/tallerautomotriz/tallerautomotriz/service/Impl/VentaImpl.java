package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.VentaDto;

import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.VentaRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IVenta;

import java.math.BigDecimal;
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

    @Override
    public List<VentaEntity> findId(Long idVenta) {
        return ventaRepository.findId(idVenta);
    }

    @Override
    public List<VentaDto> ventaConIva() {
        return ventaRepository.ventaConIva();
    }




    //para escribir
    @Override
    public VentaEntity save(VentaEntity ventaEntity) {
        return ventaRepository.save(ventaEntity);
    }







}
