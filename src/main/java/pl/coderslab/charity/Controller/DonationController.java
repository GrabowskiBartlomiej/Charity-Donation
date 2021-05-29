package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Entity.Donation;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Service.DonationServices;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("app")
public class DonationController {

    private final DonationServices donationServices;

    @Autowired
    public DonationController(DonationServices donationServices) {
        this.donationServices = donationServices;
    }

    @GetMapping("add")
    public String donationForm(Model model) {
        donationServices.getCategories(model);
        donationServices.getInstitutions(model);
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "app/form";
    }

    @PostMapping("add")
    public String processForm(@Valid Donation donation, HttpServletRequest req) {
        donationServices.addDonation(donation, req);
        return "app/form-confirmation";
    }

    @GetMapping("deleteDonation/{id}")
    public String deleteDonation(@PathVariable Long id, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        donationServices.deleteDonation(id);
        if (user.getRoles().equals("ADMIN")) {
            return "redirect:/admin/allDonations";
        } else {
            return "redirect:/user/myDonation";
        }
    }

    @GetMapping("changeDonationStatus/{id}")
    public String changeDonationStatus(@PathVariable Long id) {
        donationServices.changeDonationStatus(id);
        return "redirect:/admin/allDonations";
    }


    @GetMapping("editDonation/{id}")
    public String editDonation(Model model, @PathVariable Long id) {
        model.addAttribute("editDonation", donationServices.getDonation(id));
        donationServices.getAllInstitutions(model);
        donationServices.getCategories(model);
        return "app/editDonation";
    }

    @PostMapping("editDonation/{id}")
    public String editDonationSuccess(@Valid @ModelAttribute Donation editDonation, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
       donationServices.updateDonation(editDonation);
        if(user.getRoles().equals("ADMIN")){
            return "redirect:/admin/allDonations";
        }else {
            return "redirect:/user/myDonations";
        }
    }

}
