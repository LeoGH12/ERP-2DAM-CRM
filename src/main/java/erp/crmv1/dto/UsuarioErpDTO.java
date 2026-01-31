package erp.crmv1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioErpDTO {
    private Integer idUsuario;
    private Integer idEmpleado; // Solo el ID para no arrastrar toda la tabla Empleado
    private String email;
    private String password; // Se incluye para creación, en producción se debería ocultar en salidas
}