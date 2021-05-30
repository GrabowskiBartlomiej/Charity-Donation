package pl.coderslab.charity.controller.admin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("admin/users")
public class UsersAdminController {

    private final UserServices userServices;

    @Autowired
    public UsersAdminController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("add")
    public String addUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/addUser";
    }

    @PostMapping("add")
    public String addUserSuccess(@Valid @ModelAttribute User newUser) {
        userServices.addUser(newUser, 0);
        return "redirect:/admin/users/all";
    }

    @GetMapping("all")
    public String allUsers(Model model) {
        userServices.getUsers(model);
        return "admin/users";
    }

    @GetMapping("edit/{id}")
    public String editUser(Model model, @PathVariable Long id) {
        model.addAttribute("editUser", userServices.getUser(id));
        return "admin/editUser";
    }

    @PostMapping("edit/{id}")
    public String editUserSuccess(@Valid @ModelAttribute User editUser) {
        if (userServices.checkEmail(editUser.getEmail())) {
            userServices.updateUser(editUser);
            return "redirect:/admin/users/all";
        } else {
            return "redirect:/admin/users/edit/" + editUser.getId();
        }
    }


    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userServices.removeUser(id);
        return "redirect:/admin/users/all";
    }


}
