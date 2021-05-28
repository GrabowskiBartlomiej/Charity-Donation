package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.InstitutionRepo;
import pl.coderslab.charity.Repository.UserRepo;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserServices {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final InstitutionRepo institutionRepo;

    @Autowired
    public UserServices(UserRepo userRepo, PasswordEncoder passwordEncoder, InstitutionRepo institutionRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.institutionRepo = institutionRepo;
    }

    public void addUser(User user, int role) {
        user.setPassword(cryptPassword(user.getPassword()));
        if(role == 1){
            user.setRoles("ADMIN");
        }
        userRepo.save(user);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }

    public void removeUser(Long id) {
        userRepo.delete(userRepo.findUserById(id));
    }

    public void getLoggedUser(HttpServletRequest req) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        req.getSession().setAttribute("user", userRepo.findUserByEmail(authentication.getName()));
    }

    public User getUser(Long id) {
        return userRepo.findUserById(id);
    }

    public void getUsers(Model model) {
        model.addAttribute("users", userRepo.findAllByRoles("USER"));
    }

    public void getAdmins(Model model) {
        model.addAttribute("admins", userRepo.findAllByRoles("ADMIN"));
    }

    public void getInstitutions(Model model) {
        model.addAttribute("fundations", institutionRepo.findAll());
    }
    
    public String cryptPassword(String password){
        return passwordEncoder.encode(password);
    }

    public boolean checkNewPasswordsCompatibility(String password, String password2) {
        return password.equals(password2);
    }

    public boolean checkOldPasswordsCompatibility(Long id, String currentPassword){
        return passwordEncoder.matches(currentPassword, userRepo.findUserById(id).getPassword());
    }

    public void changePassword(Long id, String password) {
        User user = userRepo.findUserById(id);
        user.setPassword(cryptPassword(password));
        userRepo.save(user);
    }

    public boolean checkEmail(String email){
        String emailReg = "^\\S+@\\S+\\.\\S+$";
        return email.matches(emailReg);
    }

}
