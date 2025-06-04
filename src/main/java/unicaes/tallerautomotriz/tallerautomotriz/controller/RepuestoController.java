package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.RepuestoDto;
import unicaes.tallerautomotriz.tallerautomotriz.service.IRepuesto;

import java.util.List;

@RestController
@RequestMapping("/process")
public class RepuestoController {

    @Autowired
    private IRepuesto iRepuesto;

    // Obtener todos los repuestos
    @Transactional(readOnly = true)
    @GetMapping("/repuestos")
    public List<RepuestoDto> getRepuestos() {
        return iRepuesto.findAll();
    }

    // Crear nuevo repuesto
    @Transactional
    @PostMapping("/repuesto")
    public RepuestoDto saveRepuesto(@RequestBody RepuestoDto repuesto) {
        return iRepuesto.save(repuesto);
    }

    // Filtrar repuestos por categoría
    @Transactional(readOnly = true)
    @GetMapping("/repuestos/by-categoria")
    public ResponseEntity<List<RepuestoDto>> getRepuestosByCategoria(
            @RequestParam String categoria) {
        List<RepuestoDto> repuestos = iRepuesto.findByCategoria(categoria);
        return ResponseEntity.ok(repuestos);
    }

    // Obtener repuesto por ID
    @Transactional(readOnly = true)
    @GetMapping("/repuestos/{id}")
    public ResponseEntity<?> getRepuestoById(@PathVariable Long id) {
        try {
            RepuestoDto repuesto = iRepuesto.findById(id);
            return ResponseEntity.ok(repuesto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    // Eliminar repuesto por ID
    @Transactional
    @DeleteMapping("/repuestos/{id}")
    public ResponseEntity<String> deleteRepuesto(@PathVariable Long id) {
        try {
            iRepuesto.deleteById(id);
            return ResponseEntity.ok("Repuesto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
