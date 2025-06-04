package unicaes.tallerautomotriz.tallerautomotriz.service;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.RepuestoDto;
import java.util.List;

public interface IRepuesto {

    // Consultar todos
    List<RepuestoDto> findAll();

    // Consultar por ID
    RepuestoDto findById(Long id);

    // Guardar o actualizar
    RepuestoDto save(RepuestoDto repuesto);

    // Eliminar por ID
    void deleteById(Long id);

    // Filtrar por categoría
    List<RepuestoDto> findByCategoria(String categoria);
}

