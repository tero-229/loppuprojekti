package academy.ystavasovellus.controllers;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import academy.ystavasovellus.entities.Authority;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.AuthorityRepository;
import academy.ystavasovellus.service.EmailService;
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
    private EmailService emailService;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder,
                              UserService userService, EmailService emailService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
        this.emailService = emailService;
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
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Users user, BindingResult bindingResult, HttpServletRequest request) {

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
            Authority authority = new Authority();
            authority.setUsername(user.getUsername());
            authority.setAuthority("ROLE_USER");
            authorityRepository.save(authority);
            userService.saveUser(user);

            /*
            String appUrl = request.getScheme() + "://" + request.getServerName();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
            registrationEmail.setFrom("noreply@domain.com");

            emailService.sendEmail(registrationEmail);

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
            modelAndView.setViewName("register");

            */
        }
            return modelAndView;
        }

/*
    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {

        Users user = userService.findByConfirmationToken(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password"));

        if (strength.getScore() < 3) {
            //modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        Users user = userService.findByConfirmationToken(requestParams.get("token"));

        // Set new password


        // Set user to enabled
        user.setEnabled(true);

        // Save user
        userService.saveUser(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
*/
    @RequestMapping("/login")
    public String getLoginPage(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = securityContext.getAuthentication();
        if(auth != null && auth.isAuthenticated()){
            return "redirect:/index";
        }
        else return "login";
    }
}