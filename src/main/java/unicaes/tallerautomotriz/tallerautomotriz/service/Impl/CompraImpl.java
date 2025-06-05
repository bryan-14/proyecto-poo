package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.CompraRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;

import java.util.List;
import java.util.Optional;

@Service
public class CompraImpl implements ICompra {

    private final CompraRepository compraRepository;

    public CompraImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public List<CompraEntity> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<CompraEntity> findById(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public CompraEntity save(CompraEntity compra) {
        return compraRepository.save(compra);
    }

    @Override
    public CompraEntity update(Long id, CompraEntity compra) {
        return compraRepository.findById(id)
            .map(existingCompra -> {
                existingCompra.setDescripcion(compra.getDescripcion());
                existingCompra.setCantidad(compra.getCantidad());
                existingCompra.setIdRepuesto(compra.getIdRepuesto());
                existingCompra.setIdProveedor(compra.getIdProveedor());
                existingCompra.setFechaPedido(compra.getFechaPedido());
                return compraRepository.save(existingCompra);
            })
            .orElseThrow(() -> new RuntimeException("Compra not found"));
    }

    @Override
    public void delete(Long id) {
        compraRepository.deleteById(id);
    }

    @Override
    public List<CompraDTO> findComprasPorCantidad(Integer cantidad) {
        return compraRepository.findComprasPorCantidad(cantidad);
    }
}
