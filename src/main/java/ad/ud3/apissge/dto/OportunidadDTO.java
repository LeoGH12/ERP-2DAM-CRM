package ad.ud3.apissge.dto;

import ad.ud3.apissge.model.Oportunidad;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class OportunidadDTO {

    private Integer idOportunidad;
    private Integer idCliente;
    private Integer idUsuario;
    private String nombre;
    private String estado;
    private BigDecimal valorEstimado;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;

    public OportunidadDTO(Oportunidad oportunidad) {
        this.idOportunidad = oportunidad.getIdOportunidad();
        this.nombre = oportunidad.getNombre();
        this.estado = oportunidad.getEstado();
        this.valorEstimado = oportunidad.getValorEstimado();
        this.fechaCreacion = oportunidad.getFechaCreacion();
        this.fechaFin = oportunidad.getFechaFin();

        if (oportunidad.getCliente() != null) {
            this.idCliente = oportunidad.getCliente().getIdCliente();
        }

        if (oportunidad.getUsuario() != null) {
            this.idUsuario = oportunidad.getUsuario().getIdUsuario();
        }
    }
}
