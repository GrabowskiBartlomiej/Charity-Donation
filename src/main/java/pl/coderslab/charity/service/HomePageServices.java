package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.repository.DonationRepo;
import pl.coderslab.charity.repository.InstitutionRepo;

@Service
public class HomePageServices {

    private final InstitutionRepo institutionRepo;
    private final DonationRepo donationRepo;

    @Autowired
    public HomePageServices(InstitutionRepo institutionRepo, DonationRepo donationRepo) {
        this.institutionRepo = institutionRepo;
        this.donationRepo = donationRepo;
    }

    public void homePageInitialize(Model model) {
        int totalBags;
        getInstitutions(model);
        model.addAttribute("donations", donationRepo.findAll().size());
        try {
            totalBags = donationRepo.allBags();
        } catch (Exception e) {
            totalBags = 0;
        }
        model.addAttribute("totalBags", totalBags);
    }

    public void getInstitutions(Model model) {
        model.addAttribute("institutions", institutionRepo.findAll());
    }
}
