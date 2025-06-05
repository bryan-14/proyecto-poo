package unicaes.tallerautomotriz.tallerautomotriz.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;

import unicaes.tallerautomotriz.tallerautomotriz.paylod.MessageReponse;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICliente;


@RestController
@RequestMapping("/process")
public class ClienteController {

    //para leer
    @Autowired
    private ICliente iCliente;
    @Autowired

    @Transactional(readOnly = true)
    @GetMapping("/clientes")
    public ResponseEntity<?> getClientes() {
        //return iCliente.findAll();
        try {
            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iCliente.findAll())
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
    @GetMapping("/nombreClientes/{nombre}")
    public ResponseEntity<?> findNameLess(@PathVariable("nombre") String nombre) {
        try {
            if (nombre.equals("error-forzado")) {
                throw new RuntimeException("Error provocado manualmente");
            }

            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iCliente.findNameLess(nombre))
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
    @GetMapping("/buscarClienteDto")
    public ResponseEntity<?> buscarClienteDto() {
        //return iVentas.findAll();
        try {
            return new ResponseEntity<>(MessageReponse.builder()
                    .mensaje("proceso realizado con exito.")
                    .data(iCliente.buscarClienteDto())
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



    //para escribir


    @Transactional
    @PostMapping("/cliente")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) {
        return iCliente.save(cliente);
    }



// PUT para actualizar un cliente
    @Transactional
    @PutMapping("/actualizarCliente")
    public ClienteEntity updateCliente(@RequestBody ClienteEntity cliente) {

        return iCliente.save(cliente);
    }

    //para eliminar clientes
    @Transactional
    @DeleteMapping("/eliminarCliente/{id}")
        public ResponseEntity<String> deletecliente(@PathVariable Long id){
            try{
                iCliente.deleteById(id);
                return ResponseEntity.ok("cliente eliminado exitosamente");
            } catch (RuntimeException e){
                return ResponseEntity.status(404).body(e.getMessage());
            }
        }
    }

