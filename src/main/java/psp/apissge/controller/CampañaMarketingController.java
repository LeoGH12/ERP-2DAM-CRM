package psp.apissge.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psp.apissge.dto.CampañaMarketingDTO;
import psp.apissge.service.CampañaMarketingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campanas")
public class CampañaMarketingController {

    @Autowired
    private CampañaMarketingService campañaService;

    @PostMapping
    public ResponseEntity<CampañaMarketingDTO> save(@RequestBody CampañaMarketingDTO dto) {
        return new ResponseEntity<>(campañaService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CampañaMarketingDTO>> findAll() {
        return new ResponseEntity<>(campañaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampañaMarketingDTO> findById(@PathVariable Integer id) {
        CampañaMarketingDTO dto = campañaService.findById(id);
        if (dto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        campañaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
