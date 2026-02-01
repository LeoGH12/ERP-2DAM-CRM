package ad.ud3.apissge.service;

import ad.ud3.apissge.dto.OportunidadDTO;
import ad.ud3.apissge.model.Oportunidad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricaOportunidadService {

    public Oportunidad createOportunidad(OportunidadDTO dto) {
        Oportunidad oportunidad = new Oportunidad();
        oportunidad.setIdOportunidad(dto.getIdOportunidad());
        oportunidad.setNombre(dto.getNombre());
        oportunidad.setEstado(dto.getEstado());
        oportunidad.setValorEstimado(dto.getValorEstimado());
        oportunidad.setFechaCreacion(dto.getFechaCreacion());
        oportunidad.setFechaFin(dto.getFechaFin());

        return oportunidad;
    }

    public OportunidadDTO createOportunidadDTO(Oportunidad oportunidad) {
        OportunidadDTO dto = new OportunidadDTO();
        dto.setIdOportunidad(oportunidad.getIdOportunidad());
        dto.setNombre(oportunidad.getNombre());
        dto.setEstado(oportunidad.getEstado());
        dto.setValorEstimado(oportunidad.getValorEstimado());
        dto.setFechaCreacion(oportunidad.getFechaCreacion());
        dto.setFechaFin(oportunidad.getFechaFin());

        // Extraemos los IDs de los objetos relacionados si existen
        if (oportunidad.getCliente() != null) {
            dto.setIdCliente(oportunidad.getCliente().getIdCliente());
        }

        if (oportunidad.getUsuario() != null) {
            dto.setIdUsuario(oportunidad.getUsuario().getIdUsuario());
        }

        return dto;
    }

    public List<OportunidadDTO> createOportunidadDTO(List<Oportunidad> listaOportunidades) {
        return listaOportunidades.stream()
                .map(this::createOportunidadDTO)
                .collect(Collectors.toList());
    }
}
