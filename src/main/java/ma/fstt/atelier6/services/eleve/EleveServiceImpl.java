package ma.fstt.atelier6.services.eleve;

import ma.fstt.atelier6.entities.Eleve;
import ma.fstt.atelier6.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveServiceImpl implements EleveService{


    private final EleveRepository eleveRepository;

    public EleveServiceImpl(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    @Override
    public List<Eleve> listerTousLesEleves() {
        return eleveRepository.findAll();
    }

    @Override
    public Optional<Eleve> trouverParId(Long id) {
        return eleveRepository.findById(id);
    }

    @Override
    public Eleve sauverEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public void supprimerEleve(Long id) {
        if (eleveRepository.existsById(id)) {
            eleveRepository.deleteById(id);
        }
    }

    @Override
    public List<Eleve> trouverParClasse(Long classeId) {
        return eleveRepository.findByClasseId(classeId);
    }
}
