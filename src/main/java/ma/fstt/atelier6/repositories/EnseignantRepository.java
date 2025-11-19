package ma.fstt.atelier6.repositories;

import ma.fstt.atelier6.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant , Long> {
}
