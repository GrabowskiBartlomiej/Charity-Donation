package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Repository.DonationRepo;
import pl.coderslab.charity.Repository.InstitutionRepo;
import pl.coderslab.charity.Service.HomePageServices;


@Controller
public class HomeController {

    private HomePageServices homePageServices;

    @Autowired
    public HomeController(HomePageServices homePageInitialize) {
        this.homePageServices = homePageInitialize;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        homePageServices.homePageInitialize(model);
        return "index";
    }
}
