package ma.fstt.atelier6.repositories;

import ma.fstt.atelier6.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByEleveId(Long eleveId);
}
