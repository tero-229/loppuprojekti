package academy.ystavasovellus.controllers;

import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static academy.ystavasovellus.service.Filter.*;
import static academy.ystavasovellus.service.Parse.listToHTML;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/friends")
    String searchUser(@RequestBody String searchState) {

        List<Users> foundUsers = new ArrayList<>();
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        if(!(searchState.isEmpty())) {

        } return listToHTML(filterWithState(allUsers, searchState));

    }
}
    // POST-metodi, joka ottaa vastaan Search-luokan objektin ja sovittaa sitä Filter-metodeihin if-lausekkeiden mukaan. Esim. jos etsitään ystävää Hämeestä niin metodi palauttaa käyttäjät Hämeestä.


