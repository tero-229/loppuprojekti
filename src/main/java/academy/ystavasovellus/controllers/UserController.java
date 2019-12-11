package academy.ystavasovellus.controllers;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    public String listToHTML(List<Users> listed) {
        String toReturn = "";
        for (Users list : listed) {
            toReturn = toReturn + "<tr> <br/>" + "<td> <a href=" + ">" + list.getName() + "</a> </td> <td>"  +  list.getAge() + "</td> <td>" + list.getMaakunta() + "</td><td>" + list.getInfo() + "</td></tr>";
        }
        return toReturn;
    }
}

// + list.chatWith()