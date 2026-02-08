package psp.apissge.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.ClienteDTO;
import psp.apissge.model.Cliente;
import psp.apissge.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FabricaClienteService fabricaCliente;

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(fabricaCliente::createClienteDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO findById(Integer id) {
        return clienteRepository.findById(id)
                .map(fabricaCliente::createClienteDTO)
                .orElse(null);
    }

    public ClienteDTO save(ClienteDTO dto) {
        Cliente cliente = fabricaCliente.createCliente(dto);
        return fabricaCliente.createClienteDTO(clienteRepository.save(cliente));
    }
}
