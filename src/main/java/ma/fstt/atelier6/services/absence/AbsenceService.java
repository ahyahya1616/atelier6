package ma.fstt.atelier6.services.absence;

import ma.fstt.atelier6.entities.Absence;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {

    List<Absence> listerToutesLesAbsences();

    Optional<Absence> trouverParId(Long id);

    Absence sauverAbsence(Absence absence);

    void supprimerAbsence(Long id);

    List<Absence> trouverParEleve(Long eleveId);
}
