package psp.apissge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psp.apissge.model.UsuarioErp;

@Repository
public interface UsuarioErpRepository extends JpaRepository<UsuarioErp, Integer> {
}