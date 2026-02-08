package psp.apissge.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psp.apissge.dto.TareaDTO;
import psp.apissge.model.Tarea;
import psp.apissge.repository.TareaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private FabricaTareaService fabricaTarea;

    public List<TareaDTO> findAll() {
        return tareaRepository.findAll().stream()
                .map(fabricaTarea::createTareaDTO)
                .collect(Collectors.toList());
    }

    public TareaDTO findById(Integer id) {
        return tareaRepository.findById(id)
                .map(fabricaTarea::createTareaDTO)
                .orElse(null);
    }

    public TareaDTO save(TareaDTO dto) {
        // La fábrica se encarga de buscar las entidades Cliente y Usuario
        // basándose en los IDs que vienen en el DTO
        Tarea tarea = fabricaTarea.createTarea(dto);
        tarea = tareaRepository.save(tarea);
        return fabricaTarea.createTareaDTO(tarea);
    }

    public void delete(Integer id) {
        tareaRepository.deleteById(id);
    }

    // Lógica extra: Buscar tareas por cliente
    public List<TareaDTO> findByCliente(Integer idCliente) {
        return tareaRepository.findByCliente_IdCliente(idCliente).stream()
                .map(fabricaTarea::createTareaDTO)
                .collect(Collectors.toList());
    }
}