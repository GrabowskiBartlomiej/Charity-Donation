package pl.coderslab.charity.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.DonationServices;
import pl.coderslab.charity.service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserServices userServices;
    private final DonationServices donationServices;

    @Autowired
    public UserController(UserServices userServices, DonationServices donationServices) {
        this.userServices = userServices;
        this.donationServices = donationServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req){
        userServices.getLoggedUser(req);
        return "user/dashboard";
    }

}
