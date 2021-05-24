package pl.coderslab.charity.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.coderslab.charity.Entity.User;
import pl.coderslab.charity.Repository.UserRepo;
import pl.coderslab.charity.Service.UserServices;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    public UserPrincipalDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }


}
