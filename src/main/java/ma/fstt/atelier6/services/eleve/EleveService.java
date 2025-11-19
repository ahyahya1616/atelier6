package ma.fstt.atelier6.services.eleve;

import ma.fstt.atelier6.entities.Eleve;

import java.util.List;
import java.util.Optional;

public interface EleveService {
    List<Eleve> listerTousLesEleves();
    Optional<Eleve> trouverParId(Long id);
    Eleve sauverEleve(Eleve eleve);         // create / update
    void supprimerEleve(Long id);
    List<Eleve> trouverParClasse(Long classeId);
}
