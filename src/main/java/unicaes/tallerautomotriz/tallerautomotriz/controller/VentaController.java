package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.IVenta;

import java.util.List;

@RestController
@RequestMapping("/process")
public class VentaController {
    //para leer
    @Autowired
    private IVenta iVenta;

    @Transactional
    @GetMapping("/ventas")
    public List<VentaEntity> getVentas() {
        return iVenta.findAll();
    }
    //para escribir o guardar
    @Transactional
    @PostMapping("/venta")
    public VentaEntity saveVenta(@RequestBody VentaEntity compra) {
        return iVenta.save(compra);
    }
}
