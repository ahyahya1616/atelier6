package ma.fstt.atelier6.web;

import ma.fstt.atelier6.entities.Eleve;
import ma.fstt.atelier6.services.classe.ClasseService;
import ma.fstt.atelier6.services.eleve.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eleves")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    @Autowired
    private ClasseService classeService;

    // Liste des élèves
    @GetMapping
    public String listeEleves(Model model) {
        model.addAttribute("eleves", eleveService.listerTousLesEleves());
        return "eleves";   // page thymeleaf : eleves.html
    }

    // Formulaire d'ajout
    @GetMapping("/add")
    public String ajouterEleveForm(Model model) {
        model.addAttribute("eleve", new Eleve());
        model.addAttribute("classes", classeService.listerToutesLesClasses());
        return "eleve-form";   // page thymeleaf : eleve-form.html
    }

    // Sauvegarder élève (create/update)
    @PostMapping("/save")
    public String sauvegarderEleve(@ModelAttribute Eleve eleve) {
        eleveService.sauverEleve(eleve);
        return "redirect:/eleves";
    }

    // Formulaire de modification
    @GetMapping("/edit/{id}")
    public String modifierEleve(@PathVariable Long id, Model model) {
        model.addAttribute("eleve", eleveService.trouverParId(id).orElse(null));
        model.addAttribute("classes", classeService.listerToutesLesClasses());
        return "eleve-form";   // même formulaire
    }

    // Suppression
    @GetMapping("/delete/{id}")
    public String supprimerEleve(@PathVariable Long id) {
        eleveService.supprimerEleve(id);
        return "redirect:/eleves";
    }
}
