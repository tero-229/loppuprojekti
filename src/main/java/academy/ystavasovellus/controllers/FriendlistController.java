package academy.ystavasovellus.controllers;

import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static academy.ystavasovellus.service.Parse.listToHTML;
import static academy.ystavasovellus.service.Parse.stringToListLong;

public class FriendlistController {

    @Autowired
    UserRepository userRepository;

    void addFriend(Users friend, @RequestParam("token") String token) {
        Users meUser = userRepository.findByConfirmationToken(token);
        String thisFriendlist = meUser.friendlist;
        thisFriendlist += String.valueOf(friend.getId()) + ",";
        meUser.setFriendlist(thisFriendlist);
        userRepository.save(meUser);
    }


// identifikaation tarvitsee   user.getConfirmationToken    Users user = userService.findByConfirmationToken(token);
}
