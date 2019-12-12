package academy.ystavasovellus.controllers;

import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FriendlistController {

    @Autowired
    UserRepository userRepository;

    void addFriend(Users friend, Users meUser) {
        String thisFriendlist = meUser.friendlist;
        thisFriendlist += String.valueOf(friend.getId()) + ",";
        meUser.setFriendlist(thisFriendlist);
        userRepository.save(meUser);
    }
// identifikaation tarvitsee
}
