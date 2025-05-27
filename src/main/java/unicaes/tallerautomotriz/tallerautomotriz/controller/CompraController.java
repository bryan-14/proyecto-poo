package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.paylod.MessageReponse;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;



@RestController
@RequestMapping("/process")
public class CompraController {

    //para leer
    @Autowired
    private ICompra iCompra;


    @Transactional(readOnly = true)
    @GetMapping("/compras")
    public ResponseEntity<?> getPedidos() {
        try {
            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iCompra.findAll())
                    .build(),
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageReponse.builder()
                            .mensaje("Error al obtener las compras: " + e.getMessage())
                            .data(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

        /*
        @Transactional(readOnly = true)
        @GetMapping("/comprass")
        public List<CompraEntity> getPedidos() {
            return iCompra.findAll();
        }

         */



    //para escribir
    @Transactional
    @PostMapping("/compra")
    public CompraEntity savePedido(@RequestBody CompraEntity pedidoRepuesto) {
        return iCompra.save(pedidoRepuesto);
    }

}
