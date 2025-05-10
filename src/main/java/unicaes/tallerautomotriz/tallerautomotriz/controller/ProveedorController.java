package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.IProveedor;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProveedorController {
    //para leer
    @Autowired
    private IProveedor iProveedor;

    @Transactional(readOnly = true)
    @GetMapping("/proveedores")
    public List<ProveedorEntity> getProveedores() {
        return iProveedor.findAll();

    }
    //para escribir
    @Transactional
    @PostMapping("/proveedor")
    public ProveedorEntity saveProveedor(@RequestBody ProveedorEntity proveedor) {
        return iProveedor.save(proveedor);
    }
}
