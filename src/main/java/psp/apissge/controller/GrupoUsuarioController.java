package psp.apissge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psp.apissge.dto.GrupoUsuarioDTO;
import psp.apissge.service.GrupoUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grupos-usuarios")
public class GrupoUsuarioController {

    @Autowired
    private GrupoUsuarioService grupoUsuarioService;

    @PostMapping
    public ResponseEntity<GrupoUsuarioDTO> save(@RequestBody GrupoUsuarioDTO dto) {
        return new ResponseEntity<>(grupoUsuarioService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GrupoUsuarioDTO>> findAll() {
        return new ResponseEntity<>(grupoUsuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoUsuarioDTO> findById(@PathVariable Integer id) {
        GrupoUsuarioDTO dto = grupoUsuarioService.findById(id);
        if (dto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        grupoUsuarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
