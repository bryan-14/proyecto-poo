package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;
import unicaes.tallerautomotriz.tallerautomotriz.repository.CompraRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraImpl implements ICompra {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<CompraEntity> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public List<CompraEntity> findIdCompra(Long idPedido) {
        return compraRepository.findIdCompra(idPedido);
    }

    @Override
    public CompraEntity save(CompraDTO compraDTO) {
        CompraEntity compraEntity = new CompraEntity();
        // Crear un nuevo RepuestoEntity y asignar el ID
        unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity repuesto = new unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity();
        repuesto.setIdRepuesto(compraDTO.getIdRepuesto());
        compraEntity.setIdRepuesto(repuesto);
        compraEntity.setDescripcion(compraDTO.getDescripcion());
        compraEntity.setCantidad(compraDTO.getCantidad());
        compraEntity.setFechaPedido(String.valueOf(LocalDate.now()));
        return compraRepository.save(compraEntity);
    }

    @Override
    public List<CompraDTO> findComprasByCantidad(Integer cantidad) {
        return compraRepository.findComprasPorCantidad(cantidad);
    }
}
