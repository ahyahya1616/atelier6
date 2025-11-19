package ma.fstt.atelier6.web;

import ma.fstt.atelier6.entities.Classe;
import ma.fstt.atelier6.services.classe.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping
    public String listeClasses(Model model) {
        model.addAttribute("classes", classeService.listerToutesLesClasses());
        return "classes";   // classes.html
    }

    @GetMapping("/add")
    public String ajouterClasseForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "classe-form";   // classe-form.html
    }

    @PostMapping("/save")
    public String sauvegarderClasse(@ModelAttribute Classe classe) {
        classeService.sauverClasse(classe);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String modifierClasse(@PathVariable Long id, Model model) {
        model.addAttribute("classe", classeService.trouverParId(id).orElse(null));
        return "classe-form";
    }

    @GetMapping("/delete/{id}")
    public String supprimerClasse(@PathVariable Long id) {
        classeService.supprimerClasse(id);
        return "redirect:/classes";
    }
}
