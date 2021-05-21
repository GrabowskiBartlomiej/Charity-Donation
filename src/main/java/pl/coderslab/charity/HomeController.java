package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Repository.InstitutionRepo;


@Controller
public class HomeController {

    private InstitutionRepo institutionRepo;

    @Autowired
    public HomeController(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionRepo.findAll());
        for(Institution institution : institutionRepo.findAll()){
            System.out.println(institution.getName());
        }
        return "index";
    }
}
