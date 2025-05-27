package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.VentaDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.VentaEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.IVenta;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/process")
public class VentaController {
    //para leer
    @Autowired
    private IVenta iVenta;

    @Transactional(readOnly = true)
    @GetMapping("/ventas")
    public List<VentaEntity> getVentas() {
        return iVenta.findAll();
    }

    @Transactional(readOnly = true)
    @GetMapping("/buscarVentas/{totalventa}")
    public List<VentaEntity> findPriceLess(@PathVariable("totalventa") BigDecimal totalventa) {
        return iVenta.findPriceLess(totalventa);
    }

    @Transactional (readOnly = true)
    @GetMapping("ventasConIva")
    public List<VentaDto> VentaConIva(){
        return iVenta.ventaConIva();
    }




    //para escribir o guardar
    @Transactional
    @PostMapping("/venta")
    public VentaEntity saveVenta(@RequestBody VentaEntity compra) {
        return iVenta.save(compra);
    }
}
