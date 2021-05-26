package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.Institution;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.CategoryRepo;
import pl.coderslab.charity.Repository.DonationRepo;
import pl.coderslab.charity.Repository.InstitutionRepo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DonationServices {

    private DonationRepo donationRepo;
    private CategoryRepo categoryRepo;
    private InstitutionRepo institutionRepo;

    @Autowired
    public DonationServices(DonationRepo donationRepo, CategoryRepo categoryRepo, InstitutionRepo institutionRepo) {
        this.donationRepo = donationRepo;
        this.categoryRepo = categoryRepo;
        this.institutionRepo = institutionRepo;
    }


    public void getCategories(Model model) {
        model.addAttribute("allCategories", categoryRepo.findAll());
    }

    public void getInstitutions(Model model) {
        model.addAttribute("institutions", institutionRepo.findAll());
    }

    public void addDonation(Donation donation, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        donation.setUser(user);
        donationRepo.save(donation);
    }

    public void getMyDonations(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user.getId());
        System.out.println(donationRepo.myDonations(user.getId()));
        System.out.println((donationRepo.myDonations(user.getId()).size()));
        req.getSession().setAttribute("myDonations", donationRepo.myDonations(user.getId()));
    }
}
