package ma.fstt.atelier6.web;

import ma.fstt.atelier6.entities.Enseignant;
import ma.fstt.atelier6.services.classe.ClasseService;
import ma.fstt.atelier6.services.enseignant.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public String listeEnseignants(Model model) {
        model.addAttribute("enseignants", enseignantService.listerTousLesEnseignants());
        return "enseignants";   // enseignants.html
    }


    @PostMapping("/save")
    public String sauvegarderEnseignant(@ModelAttribute Enseignant enseignant) {
        enseignantService.sauverEnseignant(enseignant);
        return "redirect:/enseignants";
    }
    @GetMapping("/edit/{id}")
    public String modifierEnseignant(@PathVariable Long id, Model model) {
        model.addAttribute("enseignant", enseignantService.trouverParId(id).orElse(null));
        model.addAttribute("classes", classeService.listerToutesLesClasses());
        return "enseignant-form";
    }

    @GetMapping("/delete/{id}")
    public String supprimerEnseignant(@PathVariable Long id) {
        enseignantService.supprimerEnseignant(id);
        return "redirect:/enseignants";
    }

    @GetMapping("/add")
    public String ajouterEnseignantForm(Model model) {
        model.addAttribute("enseignant", new Enseignant());
        model.addAttribute("classes", classeService.listerToutesLesClasses());
        return "enseignant-form";
    }

}
