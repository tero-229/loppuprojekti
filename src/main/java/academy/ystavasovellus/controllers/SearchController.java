package academy.ystavasovellus.controllers;

import academy.ystavasovellus.entities.Search;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static academy.ystavasovellus.service.Filter.*;


@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    UserRepository userRepository;







    @CrossOrigin
    @PostMapping("/friends")
    void searchUser(@RequestBody Search p) {
        List<Users> allUsers = (List<Users>) userRepository.findAll();
        if(p.searchState != null && p.neutral == true) {
            filterWithState(allUsers, p.searchState);
        } else if(p.searchState != null && p.searchSport == true) {
            filteredWithSport(filterWithState(allUsers, p.searchState));
        } else if(p.searchState != null && p.searchFreetime == true) {
            filteredWithFreetime(filterWithState(allUsers, p.searchState));
        } else if(p.searchState == null && p.searchSport == true) {
            filteredWithSport(allUsers);
        } else if(p.searchState == null && p.searchFreetime == true) {
            filteredWithFreetime(allUsers);
        } else {
            noFilter(allUsers);
        }

    }
}
