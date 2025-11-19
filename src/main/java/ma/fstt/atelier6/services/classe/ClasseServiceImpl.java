package ma.fstt.atelier6.services.classe;

import ma.fstt.atelier6.entities.Classe;
import ma.fstt.atelier6.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Classe> listerToutesLesClasses() {
        return classeRepository.findAll();
    }

    @Override
    public Optional<Classe> trouverParId(Long id) {
        return classeRepository.findById(id);
    }

    @Override
    public Classe sauverClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public void supprimerClasse(Long id) {
        if (classeRepository.existsById(id)) {
            classeRepository.deleteById(id);
        }
    }
}
