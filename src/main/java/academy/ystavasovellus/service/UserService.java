package academy.ystavasovellus.service;

import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private static Log log = LogFactory.getLog(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(Users user) {
        userRepository.save(user);
    }



    public Users getCurrentUser(Authentication authentication) {
        Users activeUser = (Users) authentication.getPrincipal();
        return activeUser;
    }



    public String getLoggedInUserName() {
        try {
            return getLoggedInUser().getUsername();
        } catch (Exception ex) {
            throw new UsernameNotFoundException("Please Log in", ex);
        }
    }


    public Users getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof Users) {
            return (Users) authentication.getPrincipal();
        } else {
            throw new UsernameNotFoundException("User is not authenticated; Found " + authentication.getPrincipal() + " of type " + authentication.getPrincipal().getClass() + "; Expected type User");
        }
    }


}
