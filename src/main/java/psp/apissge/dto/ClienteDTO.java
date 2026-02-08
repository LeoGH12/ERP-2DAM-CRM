package psp.apissge.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ClienteDTO {
    private Integer idCliente;
    private String nombre;
    private LocalDate fechaAlta;
    private String estado;
}
