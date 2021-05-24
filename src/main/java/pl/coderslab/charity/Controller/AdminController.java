package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Service.UserServices;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {

    private UserServices userServices;

    @Autowired
    public AdminController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("dashboard")
    public String dashboard(HttpServletRequest req){
        userServices.getUser(req);
        return "admin/dashboard";
    }

    @GetMapping("allAdmins")
    public String allAdmins(Model model){
        userServices.getAdmins(model);
        return "admin/admins";
    }

    @GetMapping("allUsers")
    public String allUsers(Model model){
        userServices.getUsers(model);
        return "admin/users";
    }

    @GetMapping("allInstitutions")
    public String allInstitutions(Model model){
        userServices.getInstitutions(model);
        return "admin/institutions";
    }
}
