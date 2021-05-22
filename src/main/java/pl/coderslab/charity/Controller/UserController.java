package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Service.UserServices;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/form/register")
    public String registrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/form/register")
    public String validateRegForm(@Valid User user) {
        userServices.addUser(user);
        return "login";
    }
}
