package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.CategoryRepo;
import pl.coderslab.charity.repository.DonationRepo;
import pl.coderslab.charity.repository.InstitutionRepo;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class DonationServices {

    private final DonationRepo donationRepo;
    private final CategoryRepo categoryRepo;
    private final InstitutionRepo institutionRepo;

    @Autowired
    public DonationServices(DonationRepo donationRepo, CategoryRepo categoryRepo, InstitutionRepo institutionRepo) {
        this.donationRepo = donationRepo;
        this.categoryRepo = categoryRepo;
        this.institutionRepo = institutionRepo;
    }


    public void getCategories(Model model) {
        if (!model.containsAttribute("allCategories"))
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
        req.getSession().setAttribute("myDonations", donationRepo.myDonations(user.getId()));
    }

    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }

    public void deleteDonation(Long id) {
        donationRepo.delete(donationRepo.findDonationById(id));
    }

    public void changeDonationStatus(Long id) {
        Donation donation = donationRepo.findDonationById(id);

        if (donation.getPicked() == 0) {
            donation.setPicked(1);
            donation.setPickedInDate(new Date());
        } else {
            donation.setPicked(0);
        }
        donationRepo.save(donation);
    }

    public Donation getDonation(Long id) {
        return donationRepo.findDonationById(id);
    }

    public void updateDonation(Donation editDonation) {
        donationRepo.save(editDonation);
    }

    public void getAllInstitutions(Model model) {
        if (!model.containsAttribute("allInstitutions"))
            model.addAttribute("allInstitutions", institutionRepo.findAll());
    }

    public List<Donation> getAllDonationsSortedByStatusAndDate() {
        return donationRepo.findAllDonationsByStatusAndDate();
    }
}
