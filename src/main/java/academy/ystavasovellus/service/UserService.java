package academy.ystavasovellus.service;

import academy.ystavasovellus.entities.Users;
import academy.ystavasovellus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(Users user) {
        userRepository.save(user);
    }

}
