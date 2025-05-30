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
@Table(name = "compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pedido")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_Repuesto", referencedColumnName = "id_Repuesto")
    private RepuestoEntity idRepuesto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private Integer cantidad; 

    @ManyToOne
    @JoinColumn(name = "id_Proveedor", referencedColumnName = "id_Proveedor")
    private ProveedorEntity idProveedor;

    @Column(name = "fecha_pedido")
    private String fechaPedido; 





}


