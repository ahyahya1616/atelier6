package ma.fstt.atelier6.services.enseignant;

import ma.fstt.atelier6.entities.Enseignant;
import ma.fstt.atelier6.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnseignantServiceImpl implements EnseignantService {

    private final EnseignantRepository enseignantRepository;


    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public List<Enseignant> listerTousLesEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Optional<Enseignant> trouverParId(Long id) {
        return enseignantRepository.findById(id);
    }

    @Override
    public Enseignant sauverEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public void supprimerEnseignant(Long id) {
        if (enseignantRepository.existsById(id)) {
            enseignantRepository.deleteById(id);
        }
    }
}
