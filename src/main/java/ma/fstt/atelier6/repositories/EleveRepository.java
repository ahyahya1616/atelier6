package ma.fstt.atelier6.repositories;

import ma.fstt.atelier6.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleveRepository extends JpaRepository <Eleve , Long>{
    List<Eleve> findByClasseId(Long classeId);
}
