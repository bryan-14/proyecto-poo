package unicaes.tallerautomotriz.tallerautomotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import unicaes.tallerautomotriz.tallerautomotriz.entities.CompraEntity;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICompra;

import java.util.List;

@RestController
@RequestMapping("/process")
public class CompraController {

    //para leer
    @Autowired
    private ICompra ipedidoRepuesto;

    @Transactional(readOnly = true)
    @GetMapping("/compras")
    public List<CompraEntity> getPedidos() {
        return ipedidoRepuesto.findAll();
    }

    //para escribir
    @Transactional
    @PostMapping("/compra")
    public CompraEntity savePedido(@RequestBody CompraEntity pedidoRepuesto) {
        return ipedidoRepuesto.save(pedidoRepuesto);
    }

}
