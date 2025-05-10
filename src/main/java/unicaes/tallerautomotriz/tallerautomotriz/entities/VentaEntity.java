package unicaes.tallerautomotriz.tallerautomotriz.entities;

import jakarta.persistence.*;
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
@Entity
@Table (name = "venta")

public class VentaEntity {
    @Id
    @Column(columnDefinition = "int", name = "id_Venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @ManyToOne
    @JoinColumn(name = "id_Cliente", referencedColumnName = "id_Cliente")
    private ClienteEntity idCliente;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha_Venta;

    @ManyToOne
    @JoinColumn(name = "id_Repuesto", referencedColumnName = "id_Repuesto")
    private RepuestoEntity idRepuesto;

    @Column(columnDefinition = "int")
    private Long cantidad;

    @Column(columnDefinition = "decimal")
    private BigDecimal totalventa;

}
