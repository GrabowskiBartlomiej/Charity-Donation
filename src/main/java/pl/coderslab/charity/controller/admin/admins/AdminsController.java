package pl.coderslab.charity.controller.admin.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("admin/admins")
public class AdminsController {

    private final UserServices userServices;

    @Autowired
    public AdminsController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("add")
    public String addAdmin(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/addUser";
    }

    @PostMapping("add")
    public String addAdminSuccess(@Valid @ModelAttribute User newUser) {
        userServices.addUser(newUser, 1);
        return "redirect:/admin/admins/all";
    }

    @GetMapping("all")
    public String allAdmins(Model model) {
        userServices.getAdmins(model);
        return "admin/admins";
    }

    @GetMapping("edit/{id}")
    public String editAdmin(Model model, @PathVariable Long id) {
        model.addAttribute("editUser", userServices.getUser(id));
        return "admin/editUser";
    }

    @PostMapping("edit/{id}")
    public String editAdminSuccess(@Valid @ModelAttribute User editUser, HttpServletRequest req) {
        if (userServices.checkEmail(editUser.getEmail())) {
            userServices.updateUser(editUser);
            userServices.getLoggedUser(req);
            return "redirect:/admin/admins/all";
        } else {
            return "redirect:/admin/admins/edit/" + editUser.getId();
        }
    }

    @GetMapping("delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        userServices.removeUser(id);
        return "redirect:/admin/admins/all";
    }

}
