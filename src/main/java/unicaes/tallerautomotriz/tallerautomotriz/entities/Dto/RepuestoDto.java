package unicaes.tallerautomotriz.tallerautomotriz.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepuestoDto {
    private Long idRepuesto;
    private String nombre;
    private String descripcion;
    private String categoria;
}
