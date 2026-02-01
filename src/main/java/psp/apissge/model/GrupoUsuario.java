package psp.apissge.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "GrupoUsuario") // O el nombre exacto de tu tabla en BBDD
public class GrupoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo") // Mapeo exacto a tu PK
    private Integer id;

    private String nombre;
    private String descripcion;

    // Relación Inversa: Un grupo tiene muchas campañas
    // "grupoUsuario" es el nombre del atributo en la clase Java CampañaMarketing
    @OneToMany(mappedBy = "grupoUsuario", cascade = CascadeType.ALL)
    private List<CampañaMarketing> campanas;
}
