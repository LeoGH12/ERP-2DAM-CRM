package erp.crmv1.service;

import erp.crm.dto.ActividadDTO;
import erp.crm.model.Actividad;
import erp.crm.model.Cliente;
import erp.crm.model.UsuarioErp;
import erp.crm.repository.ActividadRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private FabricaActividadService fabricaActividad;

    @Autowired
    private EntityManager entityManager; // Para buscar referencias FK

    public List<ActividadDTO> findAll() {
        return actividadRepository.findAll().stream()
                .map(fabricaActividad::createActividadDTO)
                .collect(Collectors.toList());
    }

    public ActividadDTO findById(Integer id) {
        return actividadRepository.findById(id)
                .map(fabricaActividad::createActividadDTO)
                .orElse(null);
    }

    public ActividadDTO save(ActividadDTO dto) {
        // Recuperamos las entidades relacionadas
        Cliente cliente = null;
        UsuarioErp usuario = null;

        if (dto.getIdCliente() != null) {
            cliente = entityManager.find(Cliente.class, dto.getIdCliente());
        }
        if (dto.getIdUsuario() != null) {
            usuario = entityManager.find(UsuarioErp.class, dto.getIdUsuario());
        }

        Actividad actividad = fabricaActividad.createActividad(dto, cliente, usuario);
        Actividad guardada = actividadRepository.save(actividad);
        return fabricaActividad.createActividadDTO(guardada);
    }

    public void deleteById(Integer id) {
        actividadRepository.deleteById(id);
    }
}