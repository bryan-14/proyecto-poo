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
@Table (name = "repuesto")

public class RepuestoEntity {
    @Id
    @Column(columnDefinition = "int", name = "id_repuesto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepuesto;

    @Column(columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)")
    private String descripcion;

    @Column(columnDefinition = "VARCHAR(100)")
    private String categoria;

}
