package pl.coderslab.charity.controller.admin.donations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.DonationServices;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/donations")
public class DonationsAdminController {

    private final DonationServices donationServices;

    @Autowired
    public DonationsAdminController(DonationServices donationServices) {
        this.donationServices = donationServices;
    }


    @GetMapping("all")
    public String allDonations(Model model) {
        model.addAttribute("allDonations", donationServices.getAllDonations());
        return "donation/allDonations";
    }

    @GetMapping("change-status/{id}")
    public String changeDonationStatus(@PathVariable Long id) {
        donationServices.changeDonationStatus(id);
        return "redirect:/admin/donations/all";
    }


    @GetMapping("delete/{id}")
    public String deleteDonation(@PathVariable Long id, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        donationServices.deleteDonation(id);
        if (user.getRoles().equals("ADMIN")) {
            return "redirect:/admin/donations/all";
        } else {
            return "redirect:/user/donations/my-donation";
        }
    }

}
