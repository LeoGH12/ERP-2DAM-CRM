package psp.apissge.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import psp.apissge.dto.TareaDTO;
import psp.apissge.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<TareaDTO> getAll() {
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public TareaDTO getById(@PathVariable Integer id) {
        return tareaService.findById(id);
    }

    @PostMapping
    public TareaDTO create(@RequestBody TareaDTO dto) {
        return tareaService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tareaService.delete(id);
    }

    // Endpoint extra para filtrar por cliente
    @GetMapping("/cliente/{idCliente}")
    public List<TareaDTO> getByCliente(@PathVariable Integer idCliente) {
        return tareaService.findByCliente(idCliente);
    }
}
