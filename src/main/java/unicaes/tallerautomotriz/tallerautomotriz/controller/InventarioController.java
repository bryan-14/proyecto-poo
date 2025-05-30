package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.InventarioEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.InventarioDTO;
import unicaes.tallerautomotriz.tallerautomotriz.paylod.MessageReponse;
import unicaes.tallerautomotriz.tallerautomotriz.service.IInventario;

import java.util.List;

@RestController
@RequestMapping("/process")
public class InventarioController {

    @Autowired
    private IInventario iInventario;

    /**
     * Endpoint para obtener todos los inventarios.
     */
    @GetMapping("/inventarios")
    public ResponseEntity<MessageReponse> getInventarios() {
        try {
            List<InventarioEntity> inventarios = iInventario.findAll();
            return ResponseEntity.ok(
                    MessageReponse.builder()
                            .mensaje("Proceso realizado con éxito.")
                            .data(inventarios)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            MessageReponse.builder()
                                    .mensaje("Error al obtener el inventario: " + e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }

    /**
     * Endpoint para buscar inventarios por nombre.
     */
    @GetMapping("/buscarInventariosPorNombre/{nombre}")
    public ResponseEntity<MessageReponse> findByName(@PathVariable("nombre") String nombre) {
        try {
            List<InventarioEntity> inventarios = iInventario.findByName(nombre);
            if (inventarios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(
                                MessageReponse.builder()
                                        .mensaje("No se encontraron repuestos con el nombre proporcionado.")
                                        .data(null)
                                        .build()
                        );
            }
            return ResponseEntity.ok(
                    MessageReponse.builder()
                            .mensaje("Proceso realizado con éxito.")
                            .data(inventarios)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            MessageReponse.builder()
                                    .mensaje("Error al buscar respuestos por nombre: " + e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }

     @GetMapping("/buscarInventariosPorNombreDTO/{nombre}")
    public ResponseEntity<MessageReponse> findByNameAsDTO(@PathVariable("nombre") String nombre) {
        try {
            List<InventarioDTO> inventarios = iInventario.findByNameAsDTO(nombre);
            if (inventarios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(
                                MessageReponse.builder()
                                        .mensaje("No se encontraron repuestos con el nombre proporcionado.")
                                        .data(null)
                                        .build()
                        );
            }
            return ResponseEntity.ok(
                    MessageReponse.builder()
                            .mensaje("Proceso realizado con éxito.")
                            .data(inventarios)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            MessageReponse.builder()
                                    .mensaje("Error al buscar respuestos por nombre: " + e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }

    /**
     * Endpoint para crear un nuevo inventario.
     */
    @PostMapping("/inventarios")
    public ResponseEntity<MessageReponse> save(@RequestBody InventarioEntity inventario) {
        try {
            InventarioEntity nuevoInventario = iInventario.save(inventario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(
                            MessageReponse.builder()
                                    .mensaje("Inventario creado con éxito.")
                                    .data(nuevoInventario)
                                    .build()
                    );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            MessageReponse.builder()
                                    .mensaje("Error al crear el inventario: " + e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }

    /**
     * Endpoint para eliminar un inventario por ID.
     */
    @DeleteMapping("/inventarios/{idInventario}")
    public ResponseEntity<MessageReponse> delete(@PathVariable("idInventario") Long idInventario) {
        try {
            iInventario.delete(idInventario);
            return ResponseEntity.ok(
                    MessageReponse.builder()
                            .mensaje("Inventario eliminado con éxito.")
                            .data(null)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            MessageReponse.builder()
                                    .mensaje("Error al eliminar el inventario: " + e.getMessage())
                                    .data(null)
                                    .build()
                    );
        }
    }
}