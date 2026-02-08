package psp.apissge.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @Column(length = 50)
    private String estado;

    // Relación inversa (opcional pero recomendada): Un cliente tiene muchas tareas
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Tarea> tareas;
}
