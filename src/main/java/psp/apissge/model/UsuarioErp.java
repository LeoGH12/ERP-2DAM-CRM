package psp.apissge.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "USUARIOS_ERP")
public class UsuarioErp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    // Relación ignorada (tratada como campo simple según instrucciones)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 256)
    private String password;

    // Relación inversa: Un usuario tiene muchas tareas
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarea> tareas;
}
