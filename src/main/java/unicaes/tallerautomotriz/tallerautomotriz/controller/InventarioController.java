package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicaes.tallerautomotriz.tallerautomotriz.entities.InventarioEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.IInventario;

import java.util.List;


@RestController
@RequestMapping("/process")
public class InventarioController {
    @Autowired
    private IInventario iInventario;

    @Transactional
    @GetMapping("/inventarios")
    public List<InventarioEntity> getinventarios(){
        return iInventario.findAll();
    }


}


