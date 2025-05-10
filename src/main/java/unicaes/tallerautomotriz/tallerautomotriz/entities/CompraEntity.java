package unicaes.tallerautomotriz.tallerautomotriz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "compra")

public class CompraEntity {
    @Id
    @Column(columnDefinition = "int", name = "id_Pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_Repuesto", referencedColumnName = "id_Repuesto")
    private RepuestoEntity idRepuesto;

    @Column(columnDefinition = "VARCHAR(255)")
    private String descripcion;

    @Column(columnDefinition = "INT")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_Proveedor", referencedColumnName = "id_Proveedor")
    private ProveedorEntity idProveedor;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha_pedido;





}


