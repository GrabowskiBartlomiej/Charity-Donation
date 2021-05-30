package pl.coderslab.charity.controller.admin.institutions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionServices;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/institutions")
public class InstitutionsController {

    private final InstitutionServices institutionServices;

    @Autowired
    public InstitutionsController(InstitutionServices institutionServices) {
        this.institutionServices = institutionServices;
    }


    @GetMapping("add")
    public String addInstitution(Model model) {
        model.addAttribute("newInstitution", new Institution());
        return "admin/addInstitution";
    }

    @PostMapping("add")
    public String addInstitutionSuccess(@Valid @ModelAttribute Institution newInstitution) {
        institutionServices.addInstitution(newInstitution);
        return "redirect:/admin/institutions/all";
    }

    @GetMapping("all")
    public String allInstitutions(Model model) {
        institutionServices.getInstitutions(model);
        return "admin/institutions";
    }

    @GetMapping("edit/{id}")
    public String editInstitution(Model model, @PathVariable Long id) {
        model.addAttribute("editInstitution", institutionServices.getInstitution(id));
        return "admin/editInstitution";
    }

    @PostMapping("edit/{id}")
    public String editInstitutionSuccess(@Valid @ModelAttribute Institution editInstitution) {
        institutionServices.updateInstitution(editInstitution);
        return "redirect:/admin/institutions/all";
    }

    @GetMapping("delete/{id}")
    public String deleteInstitution(@PathVariable Long id) {
        institutionServices.removeInstitution(id);
        return "redirect:/admin/institutions/all";
    }

}
