package pl.coderslab.charity.controller.user.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user/profile")
public class ProfileController {

    private final UserServices userServices;

    @Autowired
    public ProfileController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("edit/{id}")
    public String userEdit(Model model, @PathVariable Long id){
        model.addAttribute("editUser", userServices.getUser(id));
        return "user/edit";
    }

    @PostMapping("edit/{id}")
    public String userEditSuccess(@Valid @ModelAttribute User editUser){
        userServices.updateUser(editUser);
        return "redirect:/user/dashboard";
    }

    @GetMapping("change-password/{id}")
    public String changePassword(){
        return "user/changePassword";
    }

    @PostMapping("change-password/{id}")
    public String changePasswordSuccess(@RequestParam String password, @RequestParam String password2, @RequestParam String currentPsw, @PathVariable Long id, HttpServletRequest req) {
        if(userServices.checkOldPasswordsCompatibility(id ,currentPsw) && userServices.checkNewPasswordsCompatibility(password,password2)){
            userServices.changePassword(id, password);
            req.getSession().removeAttribute("user");
            return "redirect:/login";
        }else {
            return "redirect:/user/profile/change-password/" + id;
        }
    }
}
