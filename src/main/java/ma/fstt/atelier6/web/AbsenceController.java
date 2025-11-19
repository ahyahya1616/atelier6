package ma.fstt.atelier6.web;

import ma.fstt.atelier6.entities.Absence;
import ma.fstt.atelier6.services.absence.AbsenceService;
import ma.fstt.atelier6.services.eleve.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private EleveService eleveService;

    // Liste des absences
    @GetMapping
    public String listeAbsences(Model model) {
        model.addAttribute("absences", absenceService.listerToutesLesAbsences());
        return "absences";   // absences.html
    }

    // Formulaire d'ajout
    @GetMapping("/add")
    public String ajouterAbsenceForm(Model model) {
        model.addAttribute("absence", new Absence());
        model.addAttribute("eleves", eleveService.listerTousLesEleves());
        return "absence-form";   // absence-form.html
    }

    // Sauvegarder absence (create/update)
    @PostMapping("/save")
    public String sauvegarderAbsence(@ModelAttribute Absence absence) {
        absenceService.sauverAbsence(absence);
        return "redirect:/absences";
    }

    // Formulaire de modification
    @GetMapping("/edit/{id}")
    public String modifierAbsence(@PathVariable Long id, Model model) {
        model.addAttribute("absence", absenceService.trouverParId(id).orElse(null));
        model.addAttribute("eleves", eleveService.listerTousLesEleves());
        return "absence-form";
    }

    // Suppression
    @GetMapping("/delete/{id}")
    public String supprimerAbsence(@PathVariable Long id) {
        absenceService.supprimerAbsence(id);
        return "redirect:/absences";
    }
}
