package academy.ystavasovellus.controllers;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import academy.ystavasovellus.security.UsersPrincipal;
import academy.ystavasovellus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static academy.ystavasovellus.service.Parse.listToHTML;
import static academy.ystavasovellus.service.Parse.stringToListLong;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {

    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    UserDetails userDetails;

    @GetMapping("/username")
    public String nonono(Authentication authentication){
        return userService.getCurrentUser(authentication).getUsername();
    }
// Principalista => user

    public List<Users> listAllUsers(){
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        return allUsers;
    }


    @CrossOrigin
    @GetMapping("/listAll")
    String listUsersHTML(){
        return listToHTML(listAllUsers());
    }

//
/*
    @PostMapping("/edit")
    @RequestMapping(value="/index.html", method = RequestMethod.POST)
    void editProfile(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("age") String age, @RequestParam("state") String state, @RequestParam("info") String info) {
    //(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("age") int age, @RequestParam("state") String state, @RequestParam("info") String info) {



          Users activeUser = userRepository.findByUsername();

            if (!first_name.isEmpty()) {
                activeUser.setFirstName(first_name);
            }
            if (!last_name.isEmpty()) {
                activeUser.setLastName(last_name);
            }
            if (!String.valueOf(age).isEmpty()) {
                try {
                    activeUser.setAge(Integer.valueOf(age));
                } catch (NumberFormatException ex) {
                    System.out.println("Error! Age has to be an integer.");
                    if (!state.isEmpty()) {
                        activeUser.setState(state);
                    }
                    if (!info.isEmpty()) {
                        activeUser.setInfo(info);
                    }
                    {
                        userRepository.save(activeUser);
                    }

                }
            }

        }
*/
/*
    @CrossOrigin
    @GetMapping("/friendlist")
    public String viewFriends() {
        String username = String.valueOf(activeUser());
        Users meUser = userRepository.findByUsername(username);
        return listFriendsHTML(meUser.friendlist);

    }
*/
    String listFriendsHTML(String friends){
        return listToHTML(longListToUsers(stringToListLong(friends)));
    }


    public List<Users> longListToUsers(List<Long> friends) {
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        List<Users> foundFriends = new ArrayList<>();
        for (Users user : allUsers) {
            for (Long friend : friends) {
                if (user.getId() == friend) {
                    foundFriends.add(user);
                }
            }
        }  return foundFriends;
    }


    }

/*
    public Users returnActiveUser(String token){
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        Users activeUser = new Users();
        for (Users user : allUsers) {
            if(user.getConfirmationToken().equals(token)) {
                activeUser = user;
            }
        } return activeUser;
    }
    */



//  user.getConfirmationToken   Users user = userService.findByConfirmationToken(token);  userService.saveUser(user);