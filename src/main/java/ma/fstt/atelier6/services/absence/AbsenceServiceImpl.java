package ma.fstt.atelier6.services.absence;



import ma.fstt.atelier6.entities.Absence;
import ma.fstt.atelier6.repositories.AbsenceRepository;
import ma.fstt.atelier6.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final EleveRepository eleveRepository;


    public AbsenceServiceImpl(AbsenceRepository absenceRepository,
                              EleveRepository eleveRepository) {
        this.absenceRepository = absenceRepository;
        this.eleveRepository = eleveRepository;
    }

    @Override
    public List<Absence> listerToutesLesAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public Optional<Absence> trouverParId(Long id) {
        return absenceRepository.findById(id);
    }

    @Override
    public Absence sauverAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public void supprimerAbsence(Long id) {
        if (absenceRepository.existsById(id)) {
            absenceRepository.deleteById(id);
        }
    }

    @Override
    public List<Absence> trouverParEleve(Long eleveId) {
        return absenceRepository.findByEleveId(eleveId);
    }
}


