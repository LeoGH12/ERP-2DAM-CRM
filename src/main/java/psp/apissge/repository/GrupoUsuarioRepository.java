package psp.apissge.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psp.apissge.model.GrupoUsuario;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, Integer> {
}
