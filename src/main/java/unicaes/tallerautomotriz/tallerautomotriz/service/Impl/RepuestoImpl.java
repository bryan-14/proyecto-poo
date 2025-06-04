
package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.RepuestoDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.RepuestoRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IRepuesto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepuestoImpl implements IRepuesto {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<RepuestoDto> findAll() {
        return repuestoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RepuestoDto findById(Long id) {
        RepuestoEntity entity = repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado con ID: " + id));
        return toDto(entity);
    }

    @Override
    public RepuestoDto save(RepuestoDto dto) {
        RepuestoEntity entity = toEntity(dto);
        RepuestoEntity saved = repuestoRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        if (!repuestoRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: Repuesto con ID " + id + " no existe");
        }
        repuestoRepository.deleteById(id);
    }

    @Override
    public List<RepuestoDto> findByCategoria(String categoria) {
        return repuestoRepository.findByCategoria(categoria).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Métodos auxiliares

    private RepuestoDto toDto(RepuestoEntity entity) {
        return new RepuestoDto(
                entity.getIdRepuesto(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getCategoria()
        );
    }

    private RepuestoEntity toEntity(RepuestoDto dto) {
        RepuestoEntity entity = new RepuestoEntity();
        entity.setIdRepuesto(dto.getIdRepuesto());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCategoria(dto.getCategoria());
        return entity;
    }
}
