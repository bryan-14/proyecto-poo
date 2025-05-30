package unicaes.tallerautomotriz.tallerautomotriz.entities.Dto;

import lombok.*;;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class InventarioDTO {

    private Long idInventario;
    private String nombre;
    private Long cantidadDisponible;
    private String proveedor;


}
