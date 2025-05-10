package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.CompraRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;

import java.util.List;

@Service
public class CompraImpl implements ICompra {

    //para leer
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<CompraEntity> findAll() {
        return compraRepository.findAll();
    }

    //para escribir

    @Override
    public CompraEntity save(CompraEntity pedidoRepuesto) {
        return compraRepository.save(pedidoRepuesto);
    }
}
