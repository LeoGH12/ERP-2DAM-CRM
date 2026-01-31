package erp.crmv1.model;

import erp.crm.model.Empleado;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USUARIOS_ERP")
public class UsuarioErp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    // Relación ManyToOne: Muchos usuarios pueden pertenecer a (o ser) empleados
    // Aunque conceptualmente suele ser 1 a 1, el SQL tiene FK simple.
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}