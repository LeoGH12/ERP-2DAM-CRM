package psp.apissge.service;

import org.springframework.stereotype.Service;
import psp.apissge.dto.UsuarioErpDTO;
import psp.apissge.model.UsuarioErp;

@Service
public class FabricaUsuarioErpService {

    public UsuarioErp createUsuario(UsuarioErpDTO dto) {
        UsuarioErp usuario = new UsuarioErp();
        usuario.setIdEmpleado(dto.getIdEmpleado());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }

    public UsuarioErpDTO createUsuarioDTO(UsuarioErp usuario) {
        UsuarioErpDTO dto = new UsuarioErpDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setIdEmpleado(usuario.getIdEmpleado());
        dto.setEmail(usuario.getEmail());
        // dto.setPassword(usuario.getPassword()); // Opcional devolverla
        return dto;
    }
}
