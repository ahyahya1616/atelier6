package ma.fstt.atelier6.services.enseignant;

import ma.fstt.atelier6.entities.Enseignant;

import java.util.List;
import java.util.Optional;

public interface EnseignantService {

    List<Enseignant> listerTousLesEnseignants();

    Optional<Enseignant> trouverParId(Long id);

    Enseignant sauverEnseignant(Enseignant enseignant);  // create + update

    void supprimerEnseignant(Long id);
}
