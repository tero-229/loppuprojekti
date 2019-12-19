package academy.ystavasovellus.controllers;

import academy.ystavasovellus.entities.Search;
import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
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
           // foundUsers = filterWithState(allUsers, searchState);
      //  } else if(p.searchState != null && p.searchSport == true) {
           // filteredWithSport(filterWithState(allUsers, p.searchState));
       // } else if(p.searchState != null && p.searchFreetime == true) {
       //     filteredWithFreetime(filterWithState(allUsers, p.searchState));
       // } else if(p.searchState == null && p.searchSport == true) {
         //   filteredWithSport(allUsers);
       // } else if(p.searchState == null && p.searchFreetime == true) {
         //   filteredWithFreetime(allUsers);
        //} else {
          //foundUsers = noFilter(allUsers);
        } return listToHTML(filterWithState(allUsers, searchState));

    }
}
