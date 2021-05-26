package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Service.DonationServices;
import pl.coderslab.charity.Service.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    private UserServices userServices;
    private DonationServices donationServices;

    @Autowired
    public UserController(UserServices userServices, DonationServices donationServices) {
        this.userServices = userServices;
        this.donationServices = donationServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req){
        userServices.getUser(req);
        return "user/dashboard";
    }

    @GetMapping("userEdit")
    public String userEdit(Model model, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user);
        model.addAttribute("editUser", user);
        return "user/edit";
    }

    @PostMapping("userEdit")
    public String userEditSuccess(@Valid @ModelAttribute User editUser, HttpServletRequest req){
        userServices.updateUser(editUser, req);
        return "redirect:/user/dashboard";
    }

    @GetMapping("changePassword")
    public String changePassword(Model model){
        User user = new User();
        model.addAttribute("editUser", user);
        return "user/changePassword";
    }

    @PostMapping("changePassword")
    public String changePasswordSuccess(@Valid @ModelAttribute User editUser, @RequestParam String currentPsw, HttpServletRequest req) {
        if (userServices.checkPasswords(req, currentPsw)) {
            userServices.changePassword(editUser, req);
            return "redirect:/user/dashboard";
        } else {
            return "redirect:/user/changePassword";
        }
    }

    @GetMapping("myDonations")
    public String myDonations(HttpServletRequest req){
        donationServices.getMyDonations(req);
        return "user/myDonations";
    }

}
