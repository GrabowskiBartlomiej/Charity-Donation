package pl.coderslab.charity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepo;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserPrincipalDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(s);
        if (user == null) {
            return null;
        } else {
            return new UserPrincipal(user);
        }
    }


}
