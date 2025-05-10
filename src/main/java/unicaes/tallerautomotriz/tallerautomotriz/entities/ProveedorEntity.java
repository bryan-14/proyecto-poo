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
@Table (name = "proveedor")

public class ProveedorEntity {
    @Id
    @Column(columnDefinition = "int", name = "id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @Column(columnDefinition = "VARCHAR(250)")
    private String nombre;

    @Column(columnDefinition = "int")
    private Long telefono;

    @Column(columnDefinition = "VARCHAR(250)")
    private String correo;

    @Column(columnDefinition = "VARCHAR(2520)")
    private String direccion;

}
