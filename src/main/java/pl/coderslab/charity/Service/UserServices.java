package pl.coderslab.charity.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entity.User;

@Service
public class UserServices {


    public void addUser(User user) {
        System.out.println(user);
    }

//    public static String hashPassword(String password) {
//        return BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
//    }
}
