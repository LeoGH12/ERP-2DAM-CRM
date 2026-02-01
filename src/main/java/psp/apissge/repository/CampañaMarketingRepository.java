package psp.apissge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psp.apissge.model.CampañaMarketing;

@Repository
public interface CampañaMarketingRepository extends JpaRepository<CampañaMarketing, Integer> {
    // Ejemplo: buscar por estado
    // List<CampañaMarketing> findByEstado(String estado);
}
