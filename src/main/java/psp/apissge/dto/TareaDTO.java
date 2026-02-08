package psp.apissge.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TareaDTO {
    private Integer idTarea;
    private String descripcion;
    private LocalDate fechaAsignacion;
    private LocalDate fechaVencimiento;
    private String estado;

    // Solo necesitamos los IDs para relacionar, no el objeto completo
    private Integer idUsuario;
    private Integer idCliente;
}
