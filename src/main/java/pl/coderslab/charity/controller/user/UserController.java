package pl.coderslab.charity.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.service.UserServices;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req) {
        userServices.getLoggedUser(req);
        return "user/dashboard";
    }

}
