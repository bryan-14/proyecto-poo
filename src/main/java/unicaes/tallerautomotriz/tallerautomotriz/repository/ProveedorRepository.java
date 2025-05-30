package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    @Query("""
    SELECT new unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto(p.nombre, p.telefono) FROM ProveedorEntity p""")
    List<ProveedorDto> buscarproveedorDto();
}
