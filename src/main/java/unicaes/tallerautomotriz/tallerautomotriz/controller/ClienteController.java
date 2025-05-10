package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICliente;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ClienteController {

    //para leer
    @Autowired
    private ICliente iCliente;

    @Transactional(readOnly = true)
    @GetMapping("/clientes")
    public List<ClienteEntity> getClientes() {
        return iCliente.findAll();


    }

    //para escribir
    @Transactional
    @PostMapping("/cliente")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) {
        return iCliente.save(cliente);
    }

}