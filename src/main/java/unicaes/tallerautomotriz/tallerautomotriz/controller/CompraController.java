package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final ICompra compraService;

    public CompraController(ICompra compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public List<CompraEntity> getAllCompras() {
        return compraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraEntity> getCompraById(@PathVariable Long id) {
        return compraService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompraEntity createCompra(@RequestBody CompraEntity compra) {
        return compraService.save(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraEntity> updateCompra(@PathVariable Long id, @RequestBody CompraEntity compra) {
        return ResponseEntity.ok(compraService.update(id, compra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id) {
        compraService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cantidad/{cantidad}")
    public List<CompraDTO> getComprasPorCantidad(@PathVariable Integer cantidad) {
        return compraService.findComprasPorCantidad(cantidad);
    }
}
