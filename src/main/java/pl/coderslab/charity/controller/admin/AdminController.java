package pl.coderslab.charity.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.service.UserServices;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserServices userServices;

    @Autowired
    public AdminController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req) {
        userServices.getLoggedUser(req);
        return "admin/dashboard";
    }

    @GetMapping("change-password/{id}")
    public String changePassword(@PathVariable Long id) {
        return "admin/changePassword";
    }

    @PostMapping("change-password/{id}")
    public String changePasswordSuccess(@PathVariable Long id, @RequestParam String password, @RequestParam String password2) {
        if (userServices.checkNewPasswordsCompatibility(password, password2)) {
            userServices.changePassword(id, password);
            if (userServices.getUser(id).getRoles().equals("ADMIN")) {
                return "redirect:/admin/admins/all";
            } else {
                return "redirect:/admin/users/all";
            }
        } else {
            return "redirect:/admin/change-password/" + id;
        }
    }

}
