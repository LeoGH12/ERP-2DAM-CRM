package erp.crmv1.repository;

import erp.crm.model.UsuarioErp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioErpRepository extends JpaRepository<UsuarioErp, Integer> { }