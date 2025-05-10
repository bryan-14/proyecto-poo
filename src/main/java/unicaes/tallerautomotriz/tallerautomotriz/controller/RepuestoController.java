package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.IRepuesto;

import java.util.List;

@RestController
@RequestMapping("/process")
public class RepuestoController {

    //para leer
    @Autowired
    private IRepuesto iRepuesto;

    @Transactional(readOnly = true)
    @GetMapping("/repuestos")
    public List<RepuestoEntity> getRepuestos(){
        return iRepuesto.findAll();

    }
    //para escribir
    @Transactional
    @PostMapping("/repuesto")
    public RepuestoEntity saveRepuesto(@RequestBody RepuestoEntity repuesto){
        return iRepuesto.save(repuesto);

    }

}
