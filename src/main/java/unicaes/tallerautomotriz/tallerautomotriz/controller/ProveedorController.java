package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.IProveedor;
import java.util.List;

@RestController
@RequestMapping("/process")
public class    ProveedorController {
    //para leer
    @Autowired
    private IProveedor iProveedor;

    @Transactional(readOnly = true)
    @GetMapping("/proveedores")
    public List<ProveedorEntity> getProveedores() {
        return iProveedor.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/proveedores/{id}")
    public ProveedorEntity getProveedorById(@PathVariable("id") Long id) {
        return iProveedor.findById(id).orElse(null);
    }

    @Transactional
    @PostMapping("/proveedores")
    public ProveedorEntity createProveedor(@RequestBody ProveedorEntity proveedor) {
        return iProveedor.save(proveedor);
    }

    @Transactional
    @PutMapping("/proveedores/{id}")
    public ResponseEntity<ProveedorEntity> updateProveedor(@PathVariable("id") Long id, @RequestBody ProveedorEntity proveedor) {
    ProveedorEntity updatedProveedor = iProveedor.update(id, proveedor);
    return ResponseEntity.ok(updatedProveedor);
}


    @Transactional
    @DeleteMapping("/proveedores/{id}")
    public void deleteProveedor(@PathVariable("id") Long id) {
        iProveedor.delete(id);
    }

    @Transactional(readOnly = true)
    @GetMapping("/proveedores/nombre/{nombre}")
    public List<ProveedorDto> findByNombre(@PathVariable("nombre") String nombre) {
        return iProveedor.findByNombre(nombre);
    }


  
}
