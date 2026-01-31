package erp.crmv1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ActividadDTO {
    private Integer idActividad;
    private Integer idCliente;
    private Integer idUsuario;
    private LocalDate fecha;
    private String descripcion;
}