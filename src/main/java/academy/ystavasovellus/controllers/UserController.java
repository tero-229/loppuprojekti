package academy.ystavasovellus.controllers;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;

import academy.ystavasovellus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


import static academy.ystavasovellus.service.Parse.listToHTML;
import static academy.ystavasovellus.service.Parse.stringToListLong;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    UserDetails userDetails;


    public List<Users> listAllUsers(){
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        return allUsers;
    }


    @CrossOrigin
    @GetMapping("/listAll")
    String listUsersHTML(){
        return listToHTML(listAllUsers());
    }

    @CrossOrigin
    @GetMapping("/getid")
    public long getActiveUsersId() {
        Users activeUser = userRepository.findByUsername(userService.getCurrentUsername());
        return activeUser.getId();
    }

    @PostMapping("/edit")
    @RequestMapping(value="/index.html", method = RequestMethod.POST)
     public void editProfile(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("age") String age, @RequestParam("state") String state, @RequestParam("info") String info) {
    //(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("age") int age, @RequestParam("state") String state, @RequestParam("info") String info) {

          Users activeUser = userRepository.findByUsername(userService.getCurrentUsername());

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


    @CrossOrigin
    @GetMapping("/friendlist")
    public String viewFriends() {
        String username = userService.getCurrentUsername();
        Users meUser = userRepository.findByUsername(username);
        return listFriendsHTML(meUser.friendlist);

    }

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


