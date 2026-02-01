package psp.apissge.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.GrupoUsuarioDTO;
import psp.apissge.model.GrupoUsuario;
import psp.apissge.repository.GrupoUsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoUsuarioService {

    @Autowired
    private GrupoUsuarioRepository grupoUsuarioRepository;

    @Autowired
    private FabricaGrupoUsuarioService fabricaGrupo;

    public GrupoUsuarioDTO save(GrupoUsuarioDTO dto) {
        GrupoUsuario grupo = fabricaGrupo.createGrupoUsuario(dto);
        return fabricaGrupo.createGrupoUsuarioDTO(grupoUsuarioRepository.save(grupo));
    }

    public List<GrupoUsuarioDTO> findAll() {
        return grupoUsuarioRepository.findAll()
                .stream()
                .map(fabricaGrupo::createGrupoUsuarioDTO)
                .collect(Collectors.toList());
    }

    public GrupoUsuarioDTO findById(Integer id) {
        return grupoUsuarioRepository.findById(id)
                .map(fabricaGrupo::createGrupoUsuarioDTO)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        grupoUsuarioRepository.deleteById(id);
    }
}
