package erp.crmv1.service;

import erp.crm.dto.UsuarioErpDTO;
import erp.crm.model.Empleado;
import erp.crm.model.UsuarioErp;
import org.springframework.stereotype.Service;

@Service
public class FabricaUsuarioErpService {

    public UsuarioErp createUsuarioErp(UsuarioErpDTO dto, Empleado empleado) {
        UsuarioErp usuario = new UsuarioErp();
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setEmpleado(empleado); // Asignamos la entidad Empleado completa
        return usuario;
    }

    public UsuarioErpDTO createUsuarioErpDTO(UsuarioErp usuario) {
        UsuarioErpDTO dto = new UsuarioErpDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setEmail(usuario.getEmail());
        dto.setPassword(usuario.getPassword());

        if (usuario.getEmpleado() != null) {
            dto.setIdEmpleado(usuario.getEmpleado().getIdEmpleado());
        }
        return dto;
    }
}