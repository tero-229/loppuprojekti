package academy.ystavasovellus.controllers;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import academy.ystavasovellus.entities.Authority;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.AuthorityRepository;
import academy.ystavasovellus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping
@Controller
public class RegisterController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder,
                              UserService userService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    // Return registration form template
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, Users user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(ModelAndView modelAndView, @Valid Users user, BindingResult bindingResult, HttpServletRequest request) {

        // Lookup user in database by e-mail
        Users userExists = userService.findByEmail(user.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else { // new user so we create user and send confirmation e-mail

            // Disable user until they click on confirmation link in email
            user.setEnabled(true);

            // Generate random 36-character string token for confirmation link
            user.setConfirmationToken(UUID.randomUUID().toString());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            Authority authority = new Authority();
            authority.setUsername(user.getUsername());
            authority.setAuthority("ROLE_USER");
            authorityRepository.save(authority);



        }
            return "login";
        }

    @RequestMapping("/login")
    public String getLoginPage(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = securityContext.getAuthentication();
        if(auth != null && auth.isAuthenticated()){
                return "/welcome";
        }
        else return "login";
    }
}