package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ClienteDto;


import java.util.List;

@Repository

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {


    @Query("SELECT p FROM ClienteEntity p WHERE p.nombre = :nombre")
    List<ClienteEntity> findNameLess(@Param("nombre") String nombre);

    @Query("""
    SELECT new unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ClienteDto(p.idCliente, p.nombre, p.apellido) FROM ClienteEntity p""")
    List<ClienteDto> buscarClienteDto();



}
