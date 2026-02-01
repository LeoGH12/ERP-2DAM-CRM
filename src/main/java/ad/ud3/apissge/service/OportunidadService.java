package ad.ud3.apissge.service;

import ad.ud3.apissge.dto.OportunidadDTO;
import ad.ud3.apissge.model.Cliente;
import ad.ud3.apissge.model.Oportunidad;
import ad.ud3.apissge.model.UsuarioErp;
import ad.ud3.apissge.repository.ClienteRepository;
import ad.ud3.apissge.repository.OportunidadRepository;
import ad.ud3.apissge.repository.UsuarioErpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OportunidadService {

    @Autowired
    private FabricaOportunidadService fabricaOportunidadService;

    @Autowired
    private OportunidadRepository oportunidadRepository;

    //Da error por que son tablas que no estas creadas aun
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioErpRepository usuarioErpRepository;

    public OportunidadDTO save(OportunidadDTO oportunidadDTO) {
        // 1. Convertimos los datos básicos usando la fábrica
        Oportunidad oportunidad = fabricaOportunidadService.createOportunidad(oportunidadDTO);

        // 2. Gestionamos la relación con CLIENTE
        if (oportunidadDTO.getIdCliente() != null) {
            Optional<Cliente> clienteOpt = clienteRepository.findById(oportunidadDTO.getIdCliente());
            if (clienteOpt.isEmpty()) {
                throw new NoSuchElementException("Cliente no encontrado con id: " + oportunidadDTO.getIdCliente());
            }
            oportunidad.setCliente(clienteOpt.get());
        }

        // 3. Gestionamos la relación con USUARIO
        if (oportunidadDTO.getIdUsuario() != null) {
            Optional<UsuarioErp> usuarioOpt = usuarioErpRepository.findById(oportunidadDTO.getIdUsuario());
            if (usuarioOpt.isEmpty()) {
                throw new NoSuchElementException("Usuario no encontrado con id: " + oportunidadDTO.getIdUsuario());
            }
            oportunidad.setUsuario(usuarioOpt.get());
        }

        // 4. Guardamos en base de datos
        oportunidad = oportunidadRepository.save(oportunidad);

        // 5. Devolvemos el DTO actualizado
        return fabricaOportunidadService.createOportunidadDTO(oportunidad);
    }

    public List<OportunidadDTO> findAll() {
        return fabricaOportunidadService.createOportunidadDTO(oportunidadRepository.findAll());
    }

    public OportunidadDTO findById(Integer id) {
        return oportunidadRepository.findById(id)
                .map(fabricaOportunidadService::createOportunidadDTO)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        oportunidadRepository.deleteById(id);
    }
}
