package psp.apissge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.UsuarioErpDTO;
import psp.apissge.model.UsuarioErp;
import psp.apissge.repository.UsuarioErpRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioErpService {

    @Autowired
    private UsuarioErpRepository usuarioRepo;

    @Autowired
    private FabricaUsuarioErpService fabricaUsuario;

    public List<UsuarioErpDTO> findAll() {
        return usuarioRepo.findAll().stream()
                .map(fabricaUsuario::createUsuarioDTO)
                .collect(Collectors.toList());
    }

    public UsuarioErpDTO save(UsuarioErpDTO dto) {
        UsuarioErp usuario = fabricaUsuario.createUsuario(dto);
        return fabricaUsuario.createUsuarioDTO(usuarioRepo.save(usuario));
    }
}
