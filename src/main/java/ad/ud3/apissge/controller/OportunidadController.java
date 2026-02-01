package ad.ud3.apissge.controller;

import ad.ud3.apissge.dto.OportunidadDTO;
import ad.ud3.apissge.service.OportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/oportunidades")
public class OportunidadController {

    @Autowired
    private OportunidadService oportunidadService;


    @GetMapping
    public ResponseEntity<List<OportunidadDTO>> findAll() {
        List<OportunidadDTO> lista = oportunidadService.findAll();
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OportunidadDTO> findById(@PathVariable Integer id) {
        OportunidadDTO dto = oportunidadService.findById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody OportunidadDTO oportunidadDTO) {
        try {
            oportunidadDTO.setIdOportunidad(null);

            OportunidadDTO guardado = oportunidadService.save(oportunidadDTO);

            return new ResponseEntity<>(guardado, HttpStatus.CREATED);

        } catch (NoSuchElementException e) {
            /
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody OportunidadDTO oportunidadDTO) {

        OportunidadDTO existente = oportunidadService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        try {

            oportunidadDTO.setIdOportunidad(id);

            OportunidadDTO actualizado = oportunidadService.save(oportunidadDTO);
            return ResponseEntity.ok(actualizado);

        } catch (NoSuchElementException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        if (oportunidadService.findById(id) == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        oportunidadService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}