package academy.ystavasovellus.controllers;

import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import academy.ystavasovellus.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


public class FriendlistController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("/addfriend")
    void addFriend(Users friend) {
        Users meUser = userRepository.findByUsername(userService.getCurrentUsername());
        String thisFriendlist = meUser.friendlist;
        thisFriendlist += String.valueOf(friend.getId()) + ",";
        meUser.setFriendlist(thisFriendlist);
        userRepository.save(meUser);
    }

    // GET-piste, jonka avulla metodille toimitettu käyttäjä lisätään aktiivisen käyttäjän ystävälistaan.

}
