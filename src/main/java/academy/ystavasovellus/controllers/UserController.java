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

    // Listaa kaikki käyttäjät.

    @CrossOrigin
    @GetMapping("/listAll")
    String listUsersHTML(){
        return listToHTML(listAllUsers());
    }

    // Listaa kaikki käyttäjät ja kääntää ne Stringiksi HTML-formaattiin (formaatti: Etunimi & Sukunimi (url-linkkinä), Ikä, Asuinpaikka ja Lisätiedot).

    @CrossOrigin
    @GetMapping("/getid")
    public long getActiveUsersId() {
        Users activeUser = userRepository.findByUsername(userService.getCurrentUsername());
        return activeUser.getId();
    }

    // Toimittaa aktiivisen käyttäjän id:n (long).

    @CrossOrigin
    @GetMapping("/getfirstname")
    public String getActiveUsersFN() {
        Users activeUser = userRepository.findByUsername(userService.getCurrentUsername());
        return activeUser.getFirstName();
    }

    @CrossOrigin
    @GetMapping("/getuser")
    public Users getCurrentUser() {
        return userRepository.findByUsername(userService.getCurrentUsername());
    }

    @CrossOrigin
    @GetMapping("/getlastname")
    public String getActiveUsersLN() {
        Users activeUser = userRepository.findByUsername(userService.getCurrentUsername());
        return activeUser.getLastName();
    }

    @PostMapping("/edit")
    public void editProfile(@RequestBody Users editedUser) {
        userRepository.save(editedUser);
    }

    // Ottaa uudet tiedot POST-metodina käyttöliittymästä ja tallettaa ne. Käyttötarkoitus: frontend pystyy muokkaamaan profiilia ja kohdistamaan sen getActiveUsersId-metodin kanssa oikeaan käyttäjään DB:ssä.

    @CrossOrigin
    @GetMapping("/friendlist")
    public String viewFriends() {
        Users meUser = userRepository.findByUsername(userService.getCurrentUsername());
        return listFriendsHTML(meUser.friendlist);
    }

    // Palauttaa Stringinä aktiivisen käyttäjän ystävälistan ja kääntää sen HTML-formaattiin.

    String listFriendsHTML(String friends){
        return listToHTML(longListToUsers(stringToListLong(friends)));
    }

    // Metodi, joka tiivistää kolmen eri metodin toiminnot itseensä. Ystävälista(string) -> longeista koostuva lista -> lista muutetaan käyttäjistä koostuvaksi listaksi -> lista muutetaan HTML-muotoon käyttöliittymää varten.

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

    // Muuttaa saamansa long-muotoisen ystävälistan ja palauttaa käyttäjämuotoisen listan.

    }


