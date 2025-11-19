package ma.fstt.atelier6.services.classe;

import ma.fstt.atelier6.entities.Classe;

import java.util.List;
import java.util.Optional;

public interface ClasseService {

    List<Classe> listerToutesLesClasses();

    Optional<Classe> trouverParId(Long id);

    Classe sauverClasse(Classe classe); // create + update

    void supprimerClasse(Long id);
}
