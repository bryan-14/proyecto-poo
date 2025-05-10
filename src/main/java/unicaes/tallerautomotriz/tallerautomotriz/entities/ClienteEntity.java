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
@Table (name= "cliente")

public class ClienteEntity {

    @Id
    @Column(columnDefinition = "int", name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(columnDefinition = "VARCHAR(250)")
    private String nombre;

    @Column(columnDefinition = "VARCHAR(250)")
    private String apellido;

    @Column(columnDefinition = "int")
    private Long telefono;

    @Column(columnDefinition = "VARCHAR(250")
    private String correo;

    @Column(columnDefinition = "VARCHAR(50)")
    private String departamento;
}

