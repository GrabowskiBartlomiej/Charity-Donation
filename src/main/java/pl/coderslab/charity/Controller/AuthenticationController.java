package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Service.UserServices;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    private UserServices userServices;

    @Autowired
    public AuthenticationController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("register")
    public String registrationForm(Model model) {
        User user = new User();
        model.addAttribute("userReg", user);
        return "register";
    }

    @PostMapping("register")
    public String validateRegForm(@Valid User user) {
        userServices.addUser(user, 0);
        return "redirect:/login";
    }

    @GetMapping("login")
    public String loginForm(){
        return "login";
    }
}
