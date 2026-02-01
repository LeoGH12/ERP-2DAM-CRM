package psp.apissge.service;

import org.springframework.stereotype.Service;
import psp.apissge.dto.GrupoUsuarioDTO;
import psp.apissge.model.GrupoUsuario;

@Service
public class FabricaGrupoUsuarioService {

    public GrupoUsuario createGrupoUsuario(GrupoUsuarioDTO dto) {
        if (dto == null) return null;
        GrupoUsuario grupo = new GrupoUsuario();
        grupo.setId(dto.getId());
        grupo.setNombre(dto.getNombre());
        grupo.setDescripcion(dto.getDescripcion());
        return grupo;
    }

    public GrupoUsuarioDTO createGrupoUsuarioDTO(GrupoUsuario entity) {
        if (entity == null) return null;
        GrupoUsuarioDTO dto = new GrupoUsuarioDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }
}
