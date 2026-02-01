package psp.apissge.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CampañaMarketing")
public class CampañaMarketing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campaña") // Mapeo a tu PK exacta
    private Integer id;

    // Relación ManyToOne: Muchas campañas tienen 1 Grupo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo") // Mapeo a tu FK exacta
    private GrupoUsuario grupoUsuario;

    private String nombre;
    private String tipo;

    @Column(name = "fecha_inicio") // Mapeo camelCase a snake_case
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    private Double presupuesto;
    private String estado;
}
