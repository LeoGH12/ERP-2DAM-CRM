package psp.apissge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CampañaMarketingDTO {
    private Integer id;

    // Este campo recibe el ID del grupo (FK) desde el JSON
    private Integer idGrupo;

    private String nombre;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double presupuesto;
    private String estado;
}