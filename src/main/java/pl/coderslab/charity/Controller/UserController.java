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
        userServices.getLoggedUser(req);
        return "user/dashboard";
    }

    @GetMapping("userEdit/{id}")
    public String userEdit(Model model, @PathVariable Long id){
        model.addAttribute("editUser", userServices.getUser(id));
        return "user/edit";
    }

    @PostMapping("userEdit/{id}")
    public String userEditSuccess(@Valid @ModelAttribute User editUser){
        userServices.updateUser(editUser);
        return "redirect:/user/dashboard";
    }

    @GetMapping("changePassword/{id}")
    public String changePassword(){
        return "user/changePassword";
    }

    @PostMapping("changePassword/{id}")
    public String changePasswordSuccess(@RequestParam String password, @RequestParam String password2, @RequestParam String currentPsw, @PathVariable Long id) {
        if(userServices.checkOldPasswordsCompatibility(id ,currentPsw) && userServices.checkNewPasswordsCompatibility(password,password2)){
                userServices.changePassword(id, password);
                return "redirect:/user/dashboard";
        }else {
            return "redirect:/user/changePassword/" + id;
        }
    }

    @GetMapping("myDonations")
    public String myDonations(HttpServletRequest req){
        donationServices.getMyDonations(req);
        return "user/myDonations";
    }

}
