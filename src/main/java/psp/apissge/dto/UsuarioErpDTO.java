package psp.apissge.dto;

import lombok.Data;

@Data
public class UsuarioErpDTO {
    private Integer idUsuario;
    private Integer idEmpleado;
    private String email;
    // Omitimos password por seguridad en el DTO de respuesta,
    // pero podría incluirse si es para creación.
    private String password;
}
