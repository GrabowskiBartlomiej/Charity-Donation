package pl.coderslab.charity.controller.user.donations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.DonationServices;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user/donations")
public class DonationsUserController {

    private final DonationServices donationServices;

    @Autowired
    public DonationsUserController(DonationServices donationServices) {
        this.donationServices = donationServices;
    }

    @GetMapping("add")
    public String donationForm(Model model) {
        donationServices.getCategories(model);
        donationServices.getInstitutions(model);
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "donation/form";
    }

    @PostMapping("add")
    public String processForm(@Valid Donation donation, HttpServletRequest req) {
        donationServices.addDonation(donation, req);
        return "donation/form-confirmation";
    }

    @GetMapping("my-donations")
    public String myDonations(HttpServletRequest req){
        donationServices.getMyDonations(req);
        return "donation/myDonations";
    }

    @GetMapping("edit/{id}")
    public String editDonation(Model model, @PathVariable Long id) {
        model.addAttribute("editDonation", donationServices.getDonation(id));
        donationServices.getAllInstitutions(model);
        donationServices.getCategories(model);
        return "donation/editDonation";
    }

    @PostMapping("edit/{id}")
    public String editDonationSuccess(@Valid @ModelAttribute Donation editDonation, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        donationServices.updateDonation(editDonation);
        if(user.getRoles().equals("ADMIN")){
            return "redirect:/admin/donations/all";
        }else {
            return "redirect:/user/donations/my-donations";
        }
    }

}
