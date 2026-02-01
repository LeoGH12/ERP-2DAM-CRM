package psp.apissge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.CampañaMarketingDTO;
import psp.apissge.model.CampañaMarketing;
import psp.apissge.model.GrupoUsuario;
import psp.apissge.repository.GrupoUsuarioRepository;

@Service
public class FabricaCampañaService {

    @Autowired
    private GrupoUsuarioRepository grupoUsuarioRepository;

    // DE DTO A ENTIDAD (Para Guardar)
    public CampañaMarketing createCampaña(CampañaMarketingDTO dto) {
        if (dto == null) return null;
        CampañaMarketing campana = new CampañaMarketing();
        campana.setId(dto.getId());
        campana.setNombre(dto.getNombre());
        campana.setTipo(dto.getTipo());
        campana.setFechaInicio(dto.getFechaInicio());
        campana.setFechaFin(dto.getFechaFin());
        campana.setPresupuesto(dto.getPresupuesto());
        campana.setEstado(dto.getEstado());

        // Lógica de Relación: Buscamos el grupo por su ID
        if (dto.getIdGrupo() != null) {
            GrupoUsuario grupo = grupoUsuarioRepository.findById(dto.getIdGrupo())
                    .orElse(null);
            // Aquí asignamos el objeto completo a la campaña
            campana.setGrupoUsuario(grupo);
        }
        return campana;
    }

    // DE ENTIDAD A DTO (Para Leer/Mostrar)
    public CampañaMarketingDTO createCampañaDTO(CampañaMarketing entity) {
        if (entity == null) return null;
        CampañaMarketingDTO dto = new CampañaMarketingDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setPresupuesto(entity.getPresupuesto());
        dto.setEstado(entity.getEstado());

        // Extraemos el ID del grupo para enviarlo en el JSON
        if (entity.getGrupoUsuario() != null) {
            dto.setIdGrupo(entity.getGrupoUsuario().getId());
        }
        return dto;
    }
}
