package academy.ystavasovellus.controllers;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import static academy.ystavasovellus.service.Parse.listToHTML;
import static academy.ystavasovellus.service.Parse.stringToListLong;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository; 


    List<Users> listAllUsers(){
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        return allUsers;
    }


    @CrossOrigin
    @GetMapping("/listAll")
    String listUsersHTML(){
        return listToHTML(listAllUsers());
    }


    @PostMapping("/edit")
    Users editUser(@RequestBody Users p) {
        Users editedUser = userRepository.save(p);
        return editedUser;
    }

    @CrossOrigin
    @GetMapping("/friends")
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

