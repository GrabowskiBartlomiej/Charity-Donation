package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.HomePageServices;
import pl.coderslab.charity.service.UserServices;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class HomeController {

    private final HomePageServices homePageServices;
    private final UserServices userServices;

    @Autowired
    public HomeController(HomePageServices homePageServices, UserServices userServices) {
        this.homePageServices = homePageServices;
        this.userServices = userServices;
    }

    @GetMapping
    public String homeAction(Model model) {
        homePageServices.homePageInitialize(model);
        return "index";
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
        userServices.sendEmailConfirmation(user);
        return "redirect:/login";
    }

    @GetMapping("login")
    public String loginForm() {
        return "login";
    }

}
