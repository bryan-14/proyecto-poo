package unicaes.tallerautomotriz.tallerautomotriz.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ClienteDto {
    private Long idCliente;
    private String nombre;
    private String apellido;

}
