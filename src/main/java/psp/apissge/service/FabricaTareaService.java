package psp.apissge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.TareaDTO;
import psp.apissge.model.Cliente;
import psp.apissge.model.Tarea;
import psp.apissge.model.UsuarioErp;
import psp.apissge.repository.ClienteRepository;
import psp.apissge.repository.UsuarioErpRepository;

@Service
public class FabricaTareaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioErpRepository usuarioRepository;

    public Tarea createTarea(TareaDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setFechaAsignacion(dto.getFechaAsignacion());
        tarea.setFechaVencimiento(dto.getFechaVencimiento());
        tarea.setEstado(dto.getEstado());

        // Buscamos y asignamos el Cliente si viene el ID
        if (dto.getIdCliente() != null) {
            Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                    .orElse(null); // O lanzar excepción personalizada
            tarea.setCliente(cliente);
        }

        // Buscamos y asignamos el Usuario si viene el ID
        if (dto.getIdUsuario() != null) {
            UsuarioErp usuario = usuarioRepository.findById(dto.getIdUsuario())
                    .orElse(null);
            tarea.setUsuario(usuario);
        }

        return tarea;
    }

    public TareaDTO createTareaDTO(Tarea tarea) {
        TareaDTO dto = new TareaDTO();
        dto.setIdTarea(tarea.getIdTarea());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setFechaAsignacion(tarea.getFechaAsignacion());
        dto.setFechaVencimiento(tarea.getFechaVencimiento());
        dto.setEstado(tarea.getEstado());

        // Extraemos los IDs de las entidades relacionadas para el DTO
        if (tarea.getCliente() != null) {
            dto.setIdCliente(tarea.getCliente().getIdCliente());
        }
        if (tarea.getUsuario() != null) {
            dto.setIdUsuario(tarea.getUsuario().getIdUsuario());
        }

        return dto;
    }
}