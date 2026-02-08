package psp.apissge.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import psp.apissge.dto.UsuarioErpDTO;
import psp.apissge.service.UsuarioErpService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioErpController {

    @Autowired
    private UsuarioErpService usuarioService;

    @GetMapping
    public List<UsuarioErpDTO> getAll() {
        return usuarioService.findAll();
    }

    @PostMapping
    public UsuarioErpDTO create(@RequestBody UsuarioErpDTO dto) {
        return usuarioService.save(dto);
    }
}
