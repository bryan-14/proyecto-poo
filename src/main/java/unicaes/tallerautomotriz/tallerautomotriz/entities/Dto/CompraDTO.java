package unicaes.tallerautomotriz.tallerautomotriz.entities.Dto;

import lombok.*;

@Data
@NoArgsConstructor
public class CompraDTO {

    private Long idPedido;
    private String descripcion;
    private Integer cantidad;
    private String fechaPedido;
    private Long idRepuesto;
    

    public CompraDTO(Long idPedido, String descripcion, Integer cantidad, String fechaPedido) {
        this.idPedido = idPedido;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.idRepuesto = null; // Inicializar idRepuesto como null
    }
}