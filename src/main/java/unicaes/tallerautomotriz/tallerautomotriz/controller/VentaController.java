package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;
import unicaes.tallerautomotriz.tallerautomotriz.paylod.MessageReponse;
import unicaes.tallerautomotriz.tallerautomotriz.service.IVenta;


@RestController
@RequestMapping("/process")
public class VentaController {
    //para leer
    @Autowired
    private IVenta iVenta;


    @Transactional(readOnly = true)
    @GetMapping("/ventas")
    public ResponseEntity<?> getVentas() {
        try {
            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iVenta.findAll())
                    .build(),
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageReponse.builder()
                            .mensaje("Error al obtener las compras: " + e.getMessage())
                            .data(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Transactional(readOnly = true)
    @GetMapping("/buscarVentasPorId/{idVenta}")
    public ResponseEntity<?> findId(@PathVariable("idVenta") Long venta) {
        try {

            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iVenta.findId(venta))
                    .build(),
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageReponse.builder()
                            .mensaje("Error al obtener las compras: " + e.getMessage())
                            .data(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Transactional(readOnly = true)
    @GetMapping("/ventasConIva")
    public ResponseEntity<?> VentaConIva() {
        //return iVentas.findAll();
        try {
            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iVenta.ventaConIva())
                    .build(),
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageReponse.builder()
                            .mensaje("Error al obtener las compras: " + e.getMessage())
                            .data(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //para escribir o guardar
    @Transactional
    @PostMapping("/venta")
    public VentaEntity saveVenta(@RequestBody VentaEntity compra) {
        return iVenta.save(compra);
    }

    
    //actualizar ventas
    @Transactional
    @PutMapping("/venta")
    public VentaEntity updateVenta(@RequestBody VentaEntity compra) {
        return iVenta.save(compra);
    }

    //eliminar cliente
    @Transactional
    @DeleteMapping("/venta/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id){
        try {
            iVenta.deleteVenta(id);
            return ResponseEntity.ok("Venta eliminada exitosamente");
        } catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
        
        }
    }



