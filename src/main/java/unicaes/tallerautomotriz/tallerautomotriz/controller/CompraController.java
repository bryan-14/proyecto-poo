package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.CompraDTO;
import unicaes.tallerautomotriz.tallerautomotriz.paylod.MessageReponse;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;

@RestController
@RequestMapping("/process")
public class CompraController {

    @Autowired
    private ICompra iCompra;

    @Transactional(readOnly = true)
    @GetMapping("/compras")
    public ResponseEntity<?> getPedidos() {
        try {
            return ResponseEntity.ok(MessageReponse.builder()
                    .mensaje("Proceso realizado con éxito.")
                    .data(iCompra.findAll())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MessageReponse.builder()
                            .mensaje("Error al obtener las compras: " + e.getMessage())
                            .data(null)
                            .build());
        }
    }


    @Transactional(readOnly = true)
    @GetMapping("/idCompras/{idPedido}")
    public ResponseEntity<?> findIdCompra(@PathVariable("idPedido") Long idPedido) {
        try {
            return ResponseEntity.ok(MessageReponse.builder()
                    .mensaje("Proceso realizado con éxito.")
                    .data(iCompra.findIdCompra(idPedido))
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MessageReponse.builder()
                            .mensaje("Error al obtener las compras por ID: " + e.getMessage())
                            .data(null)
                            .build());
        }
    }


    @Transactional(readOnly = true)
    @GetMapping("/comprasPorCantidad/{cantidad}")
    public ResponseEntity<?> findComprasByCantidad(@PathVariable("cantidad") Integer cantidad) {
        try {
            return ResponseEntity.ok(MessageReponse.builder()
                    .mensaje("Proceso realizado con éxito.")
                    .data(iCompra.findComprasByCantidad(cantidad))
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MessageReponse.builder()
                            .mensaje("Error al obtener las compras por cantidad: " + e.getMessage())
                            .data(null)
                            .build());
        }
    }

    @PostMapping("/compras")
    public ResponseEntity<?> saveCompra(@RequestBody CompraDTO compraDTO) {
        try {
            CompraEntity savedCompra = iCompra.save(compraDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(MessageReponse.builder()
                            .mensaje("Compra guardada con éxito.")
                            .data(savedCompra)
                            .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MessageReponse.builder()
                            .mensaje("Error al guardar la compra: " + e.getMessage())
                            .data(null)
                            .build());
        }
    }
}