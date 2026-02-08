package psp.apissge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psp.apissge.model.Tarea;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    // Ejemplos de búsquedas útiles
    List<Tarea> findByCliente_IdCliente(Integer idCliente);
    List<Tarea> findByUsuario_IdUsuario(Integer idUsuario);
}
