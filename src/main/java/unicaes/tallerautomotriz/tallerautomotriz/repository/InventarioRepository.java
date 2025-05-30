package unicaes.tallerautomotriz.tallerautomotriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unicaes.tallerautomotriz.tallerautomotriz.entities.InventarioEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.InventarioDTO;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {


    @Query("SELECT p FROM InventarioEntity p WHERE p.nombre LIKE %:nombre%")
    List<InventarioEntity> findByName(@Param("nombre") String nombre);

     @Query("SELECT NEW unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.InventarioDTO("
            + "i.idInventario, i.nombre, i.cantidad_Disponible, i.id_Proveedor.nombre) "
            + "FROM InventarioEntity i WHERE i.nombre LIKE %:nombre%")
    List<InventarioDTO> findByNameAsDTO(@Param("nombre") String nombre);
  }

