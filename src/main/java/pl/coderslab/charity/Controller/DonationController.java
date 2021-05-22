package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Service.DonationServices;

import javax.validation.Valid;

@Controller
public class DonationController {

    private DonationServices donationServices;

    @Autowired
    public DonationController(DonationServices donationServices){
        this.donationServices = donationServices;
    }

    @GetMapping("/form/add")
    public String donationForm(Model model){
        donationServices.getCategories(model);
        donationServices.getInstitutions(model);
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form";
    }

    @PostMapping("/form/add")
    public String processForm(@Valid Donation donation){
        donationServices.addDonation(donation);
        return "form-confirmation";
    }
}
