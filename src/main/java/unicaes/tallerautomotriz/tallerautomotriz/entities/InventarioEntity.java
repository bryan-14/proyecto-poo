package unicaes.tallerautomotriz.tallerautomotriz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventario")

public class InventarioEntity {

    @Id
    @Column(columnDefinition = "int ", name = "id_Inventario")
    private Long id_Inventario;

    @ManyToOne
    @JoinColumn(name = "id_repuesto", referencedColumnName = "id_Repuesto")
    private RepuestoEntity idRepuesto;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nombre;

    @Column(columnDefinition = "int")
    private Long cantidad_Disponible;

    @ManyToOne
    @JoinColumn(name = "id_Proveedor", referencedColumnName = "id_Proveedor")
    private ProveedorEntity id_Proveedor;





}


