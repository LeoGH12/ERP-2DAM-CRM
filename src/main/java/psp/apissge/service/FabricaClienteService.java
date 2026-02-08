package psp.apissge.service;

import org.springframework.stereotype.Service;
import psp.apissge.dto.ClienteDTO;
import psp.apissge.model.Cliente;

@Service
public class FabricaClienteService {

    public Cliente createCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setFechaAlta(dto.getFechaAlta());
        cliente.setEstado(dto.getEstado());
        return cliente;
    }

    public ClienteDTO createClienteDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNombre(cliente.getNombre());
        dto.setFechaAlta(cliente.getFechaAlta());
        dto.setEstado(cliente.getEstado());
        return dto;
    }
}
