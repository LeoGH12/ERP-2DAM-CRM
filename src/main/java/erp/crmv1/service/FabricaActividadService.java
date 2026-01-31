package erp.crmv1.service;

import erp.crm.dto.ActividadDTO;
import erp.crm.model.Actividad;
import erp.crm.model.Cliente;
import erp.crm.model.UsuarioErp;
import org.springframework.stereotype.Service;

@Service
public class FabricaActividadService {

    public Actividad createActividad(ActividadDTO dto, Cliente cliente, UsuarioErp usuario) {
        Actividad actividad = new Actividad();
        actividad.setIdActividad(dto.getIdActividad());
        actividad.setFecha(dto.getFecha());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setCliente(cliente);
        actividad.setUsuario(usuario);
        return actividad;
    }

    public ActividadDTO createActividadDTO(Actividad actividad) {
        ActividadDTO dto = new ActividadDTO();
        dto.setIdActividad(actividad.getIdActividad());
        dto.setFecha(actividad.getFecha());
        dto.setDescripcion(actividad.getDescripcion());

        if (actividad.getCliente() != null) {
            dto.setIdCliente(actividad.getCliente().getIdCliente());
        }
        if (actividad.getUsuario() != null) {
            dto.setIdUsuario(actividad.getUsuario().getIdUsuario());
        }
        return dto;
    }
}