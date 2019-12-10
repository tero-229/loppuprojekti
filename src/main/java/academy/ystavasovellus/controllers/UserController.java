package academy.ystavasovellus.controllers;
import academy.ystavasovellus.entities.User;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/listAll")
    List<User> listAllUsers(){
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers;
    }

    @PostMapping("/edit")
    User editUser(@RequestBody User p) {
        User editedUser = userRepository.save(p);
        return editedUser;
    }

    public String listToString(List<User> listed) {
        String toReturn = "";
        for (User list : listed) {
            toReturn = toReturn + "<tr> <br/>" + "<td> <a href=" + ">" + list.getName() + "</a> </td> <td>"  +  list.getAge() + "</td> <td>" + list.getMaakunta() + "</td><td>" + list.getInfo() + "</td></tr>";
        }
        return toReturn;
    }
}

// + list.chatWith()