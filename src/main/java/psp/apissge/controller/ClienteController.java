package psp.apissge.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import psp.apissge.dto.ClienteDTO;
import psp.apissge.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteDTO create(@RequestBody ClienteDTO dto) {
        return clienteService.save(dto);
    }
}
