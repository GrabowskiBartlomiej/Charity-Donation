package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Service.InstitutionServices;
import pl.coderslab.charity.Service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    private UserServices userServices;
    private InstitutionServices institutionServices;

    @Autowired
    public AdminController(UserServices userServices, InstitutionServices institutionServices) {
        this.userServices = userServices;
        this.institutionServices = institutionServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req){
        userServices.getUser(req);
        return "admin/dashboard";
    }

    @GetMapping("allAdmins")
    public String allAdmins(Model model){
        userServices.getAdmins(model);
        return "admin/admins";
    }

    @GetMapping("allUsers")
    public String allUsers(Model model){
        userServices.getUsers(model);
        return "admin/users";
    }

    @GetMapping("allInstitutions")
    public String allInstitutions(Model model){
        userServices.getInstitutions(model);
        return "admin/institutions";
    }

    @GetMapping("addInstitution")
    public String addInstitution(Model model){
        model.addAttribute("newInstitution", new Institution());
        return "admin/addInstitution";
    }

    @PostMapping ("addInstitution")
    public String addInstitutionSuccess(@Valid @ModelAttribute Institution newInstitution){
        institutionServices.addInstitution(newInstitution);
        return "redirect:/admin/allInstitutions";
    }

    @GetMapping ("deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionServices.removeInstitution(id);
        return "redirect:/admin/allInstitutions";
    }

    @GetMapping("editInstitution/{id}")
    public String editInstitution(Model model, @PathVariable Long id){
        model.addAttribute("editInstitution", institutionServices.getInstitution(id));
        return "/admin/editInstitution";
    }

    @PostMapping("editInstitution/{id}")
    public String editInstitutionSuccess(@Valid @ModelAttribute Institution editInstitution){
        institutionServices.updateInstitution(editInstitution);
        return "redirect:/admin/allInstitutions";
    }
}
