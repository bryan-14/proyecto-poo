package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;



import java.util.List;

@Repository

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {


    @Query("SELECT p FROM ClienteEntity p WHERE p.nombre = :nombre")
    List<ClienteEntity> findNameLess(@Param("nombre") String nombre);

/*
    @Query("SELECT NEW unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ClienteDto(c.idCliente, c.nombre, c.apellido) " +
            "FROM ClienteEntity c WHERE c.idCliente = :id")
    ClienteDto findClienteSimpleById(@Param("id") Long id);

 */
}
