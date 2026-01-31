package erp.crmv1.service;

import erp.crm.dto.UsuarioErpDTO;
import erp.crm.model.Empleado;
import erp.crm.model.UsuarioErp;
import erp.crm.repository.UsuarioErpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioErpService {

    @Autowired
    private UsuarioErpRepository usuarioRepository;

    @Autowired
    private FabricaUsuarioErpService fabricaUsuario;

    // Necesitamos el repo de Empleado (que hará tu compañero) para buscarlo por ID
    // Usamos 'EntityManager' o asumimos que tienes EmpleadoRepository.
    // Para simplificar y que compile, usaré una referencia simple o Mock.
    @Autowired
    private jakarta.persistence.EntityManager entityManager;

    public List<UsuarioErpDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(fabricaUsuario::createUsuarioErpDTO)
                .collect(Collectors.toList());
    }

    public UsuarioErpDTO findById(Integer id) {
        return usuarioRepository.findById(id)
                .map(fabricaUsuario::createUsuarioErpDTO)
                .orElse(null);
    }

    public UsuarioErpDTO save(UsuarioErpDTO dto) {
        // Buscamos la entidad Empleado si viene el ID
        Empleado empleado = null;
        if (dto.getIdEmpleado() != null) {
            empleado = entityManager.find(Empleado.class, dto.getIdEmpleado());
        }

        UsuarioErp usuario = fabricaUsuario.createUsuarioErp(dto, empleado);
        UsuarioErp guardado = usuarioRepository.save(usuario);
        return fabricaUsuario.createUsuarioErpDTO(guardado);
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}