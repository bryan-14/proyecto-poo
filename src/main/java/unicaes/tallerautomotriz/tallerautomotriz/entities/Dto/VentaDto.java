package unicaes.tallerautomotriz.tallerautomotriz.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class VentaDto {
    private Long idVenta;
    private LocalDate fechaVenta;
    private BigDecimal totalVenta;
    private double iva;



}
