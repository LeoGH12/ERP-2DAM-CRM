package psp.apissge.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GrupoUsuarioDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
}
