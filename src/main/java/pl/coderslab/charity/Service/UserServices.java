package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.InstitutionRepo;
import pl.coderslab.charity.Repository.UserRepo;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class UserServices {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private InstitutionRepo institutionRepo;

    @Autowired
    public UserServices(UserRepo userRepo, PasswordEncoder passwordEncoder, InstitutionRepo institutionRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.institutionRepo = institutionRepo;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public void getUser(HttpServletRequest req) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByEmail(authentication.getName());
        req.getSession().setAttribute("user", user);
    }

    public void getAdmins(Model model) {
        model.addAttribute("admins", userRepo.findAllByRoles("ADMIN"));
    }

    public void getUsers(Model model) {
        model.addAttribute("users", userRepo.findAllByRoles("USER"));
    }


    public void getInstitutions(Model model) {
        model.addAttribute("fundations", institutionRepo.findAll());
    }

    public void updateUser(User user, HttpServletRequest req) {
        User dbUser = (User) req.getSession().getAttribute("user");
        System.out.println(dbUser);
        dbUser.setName(user.getName());
        dbUser.setSurname(user.getSurname());
        dbUser.setEmail(user.getEmail());
        userRepo.save(dbUser);
    }

    public void changePassword(User user, HttpServletRequest req){
        User dbUser = (User) req.getSession().getAttribute("user");
        dbUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(dbUser);
    }

    public boolean checkPasswords(HttpServletRequest req, String password2) {
        User user = (User) req.getSession().getAttribute("user");
        if(passwordEncoder.matches(password2, user.getPassword())){
            return true;
        }else {
            return false;
        }
    }


    public void addAdmin(User addAdmin) {
        addAdmin.setRoles("ADMIN");
        userRepo.save(addAdmin);
    }

    public void removeUser(Long id) {
        userRepo.delete(userRepo.findUserById(id));
    }

    public User getUser(Long id){
       return userRepo.findUserById(id);
    }

    public void changePsw(Long id, String password) {
        User user = userRepo.findUserById(id);
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
    }

    public void updateAdmin(User editAdmin) {
        User user = userRepo.findUserById(editAdmin.getId());
        user.setEmail(editAdmin.getEmail());
        user.setName(editAdmin.getName());
        user.setSurname(editAdmin.getSurname());
        user.setRoles(editAdmin.getRoles());
        userRepo.save(user);
    }
}
