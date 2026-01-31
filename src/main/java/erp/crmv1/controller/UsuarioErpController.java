package erp.crmv1.controller;

import erp.crm.dto.UsuarioErpDTO;
import erp.crm.service.UsuarioErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crm/usuarios")
public class UsuarioErpController {

    @Autowired
    private UsuarioErpService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioErpDTO>> getAll() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioErpDTO> getById(@PathVariable Integer id) {
        UsuarioErpDTO dto = usuarioService.findById(id);
        if (dto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioErpDTO> create(@RequestBody UsuarioErpDTO dto) {
        return new ResponseEntity<>(usuarioService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioErpDTO> update(@PathVariable Integer id, @RequestBody UsuarioErpDTO dto) {
        if (usuarioService.findById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        dto.setIdUsuario(id);
        return new ResponseEntity<>(usuarioService.save(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}