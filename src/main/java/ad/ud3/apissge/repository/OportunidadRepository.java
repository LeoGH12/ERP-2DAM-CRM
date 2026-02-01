package ad.ud3.apissge.repository;

import ad.ud3.apissge.model.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Integer> {


    List<Oportunidad> findByCliente_IdCliente(Integer idCliente);


    List<Oportunidad> findByUsuario_IdUsuario(Integer idUsuario);


    List<Oportunidad> findByEstado(String estado);


    List<Oportunidad> findByCliente_IdClienteAndEstado(Integer idCliente, String estado);
}
