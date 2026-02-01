package ad.ud3.apissge.model;

import ad.ud3.apissge.dto.OportunidadDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "OPORTUNIDADES")
public class Oportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oportunidad")
    private Integer idOportunidad;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    // Muchas oportunidades -> Un usuario ERP
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioErp usuario;


    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "valor_estimado", precision = 10, scale = 2)
    private BigDecimal valorEstimado;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;


    public Oportunidad(OportunidadDTO dto) {
        this.idOportunidad = dto.getIdOportunidad();
        this.nombre = dto.getNombre();
        this.estado = dto.getEstado();
        this.valorEstimado = dto.getValorEstimado();
        this.fechaCreacion = dto.getFechaCreacion();
        this.fechaFin = dto.getFechaFin();

        if (dto.getIdCliente() != null) {
            this.cliente = new Cliente();
            this.cliente.setIdCliente(dto.getIdCliente());
        }

        if (dto.getIdUsuario() != null) {
            this.usuario = new UsuarioErp();
            this.usuario.setIdUsuario(dto.getIdUsuario());
        }
    }
}
