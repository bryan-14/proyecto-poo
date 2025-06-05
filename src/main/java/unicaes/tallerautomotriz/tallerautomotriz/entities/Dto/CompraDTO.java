package unicaes.tallerautomotriz.tallerautomotriz.entities.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private Long idPedido;
    private String descripcion;
    private Integer cantidad;
    private Long idRepuesto;
    private String fechaPedido;
}