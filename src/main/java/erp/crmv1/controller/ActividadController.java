package erp.crmv1.controller;

import erp.crm.dto.ActividadDTO;
import erp.crm.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crm/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<ActividadDTO>> getAll() {
        return new ResponseEntity<>(actividadService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> getById(@PathVariable Integer id) {
        ActividadDTO dto = actividadService.findById(id);
        if (dto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActividadDTO> create(@RequestBody ActividadDTO dto) {
        return new ResponseEntity<>(actividadService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDTO> update(@PathVariable Integer id, @RequestBody ActividadDTO dto) {
        if (actividadService.findById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        dto.setIdActividad(id);
        return new ResponseEntity<>(actividadService.save(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        actividadService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}