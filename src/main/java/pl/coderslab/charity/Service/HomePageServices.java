package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.Repository.DonationRepo;
import pl.coderslab.charity.Repository.InstitutionRepo;

@Service
public class HomePageServices {

    private InstitutionRepo institutionRepo;
    private DonationRepo donationRepo;

    @Autowired
    public HomePageServices(InstitutionRepo institutionRepo, DonationRepo donationRepo) {
        this.institutionRepo = institutionRepo;
        this.donationRepo = donationRepo;
    }

    public void homePageInitialize(Model model) {
        int totalBags;
        model.addAttribute("institutions", institutionRepo.findAll());
        model.addAttribute("donations", donationRepo.findAll().size());
        try {
            totalBags = donationRepo.allBags();
        } catch (Exception e) {
            totalBags = 0;
        }
        System.out.println(totalBags);
        model.addAttribute("totalBags", totalBags);
    }

}
