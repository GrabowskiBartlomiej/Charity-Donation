package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Service.DonationServices;
import pl.coderslab.charity.Service.InstitutionServices;
import pl.coderslab.charity.Service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserServices userServices;
    private final InstitutionServices institutionServices;
    private final DonationServices donationServices;

    @Autowired
    public AdminController(UserServices userServices, InstitutionServices institutionServices, DonationServices donationServices) {
        this.userServices = userServices;
        this.institutionServices = institutionServices;
        this.donationServices = donationServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req) {
        userServices.getLoggedUser(req);
        return "admin/dashboard";
    }

    @GetMapping("allAdmins")
    public String allAdmins(Model model) {
        userServices.getAdmins(model);
        return "admin/admins";
    }

    @GetMapping("allUsers")
    public String allUsers(Model model) {
        userServices.getUsers(model);
        return "admin/users";
    }

    @GetMapping("allInstitutions")
    public String allInstitutions(Model model) {
        userServices.getInstitutions(model);
        return "admin/institutions";
    }

    @GetMapping("addInstitution")
    public String addInstitution(Model model) {
        model.addAttribute("newInstitution", new Institution());
        return "admin/addInstitution";
    }

    @PostMapping("addInstitution")
    public String addInstitutionSuccess(@Valid @ModelAttribute Institution newInstitution) {
        institutionServices.addInstitution(newInstitution);
        return "redirect:/admin/allInstitutions";
    }

    @GetMapping("deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable Long id) {
        institutionServices.removeInstitution(id);
        return "redirect:/admin/allInstitutions";
    }

    @GetMapping("editInstitution/{id}")
    public String editInstitution(Model model, @PathVariable Long id) {
        model.addAttribute("editInstitution", institutionServices.getInstitution(id));
        return "/admin/editInstitution";
    }

    @PostMapping("editInstitution/{id}")
    public String editInstitutionSuccess(@Valid @ModelAttribute Institution editInstitution) {
        institutionServices.updateInstitution(editInstitution);
        return "redirect:/admin/allInstitutions";
    }

    @GetMapping("addAdmin")
    public String addAdmin(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/addAdmin";
    }

    @PostMapping("addAdmin")
    public String addAdminSuccess(@Valid @ModelAttribute User newUser) {
        userServices.addUser(newUser, 1);
        return "redirect:/admin/allAdmins";
    }

    @GetMapping("deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        userServices.removeUser(id);
        return "redirect:/admin/allAdmins";
    }

    @GetMapping("editAdmin/{id}")
    public String editAdmin(Model model, @PathVariable Long id) {
        model.addAttribute("editUser", userServices.getUser(id));
        return "/admin/editAdmin";
    }

    @PostMapping("editAdmin/{id}")
    public String editAdminSuccess(@Valid @ModelAttribute User editUser, HttpServletRequest req) {
        if (userServices.checkEmail(editUser.getEmail())) {
            userServices.updateUser(editUser);
            userServices.getLoggedUser(req);
            return "redirect:/admin/allAdmins";
        } else {
            return "redirect:/admin/editAdmin/" + editUser.getId();
        }
    }

    @GetMapping("changePassword/{id}")
    public String changePassword(@PathVariable Long id) {
        return "/admin/changePassword";
    }

    @PostMapping("changePassword/{id}")
    public String changePasswordSuccess(@PathVariable Long id, @RequestParam String password, @RequestParam String password2) {
        if (userServices.checkNewPasswordsCompatibility(password, password2)) {
            userServices.changePassword(id, password);
            if (userServices.getUser(id).getRoles().equals("ADMIN")) {
                return "redirect:/admin/allAdmins";
            } else {
                return "redirect:/admin/allUsers";
            }
        } else {
            return "redirect:/admin/changePassword/" + id;
        }
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userServices.removeUser(id);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("editUser/{id}")
    public String editUser(Model model, @PathVariable Long id) {
        model.addAttribute("editUser", userServices.getUser(id));
        return "/admin/editAdmin";
    }

    @PostMapping("editUser/{id}")
    public String editUserSuccess(@Valid @ModelAttribute User editUser) {
        if (userServices.checkEmail(editUser.getEmail())) {
            userServices.updateUser(editUser);
            return "redirect:/admin/allUsers";
        } else {
            return "redirect:/admin/editUser/" + editUser.getId();
        }
    }

    @GetMapping("addUser")
    public String addUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/addAdmin";
    }

    @PostMapping("addUser")
    public String addUserSuccess(@Valid @ModelAttribute User newUser) {
        userServices.addUser(newUser, 0);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("allDonations")
    public String allDonations(Model model) {
        model.addAttribute("allDonations", donationServices.getAllDonations());
        return "/admin/allDonations";
    }


}
