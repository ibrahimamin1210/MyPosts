package com.myposts.services.users;

import com.myposts.services.users.exceptions.UserNotFoundException;
import com.myposts.services.users.exceptions.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    @Qualifier("passwordEncoder")
    private BCryptPasswordEncoder encoder;

    public User findByName(String userName) {
        return userRepo.findByuserName(userName);
    }

    public User validateUserAuthority(String userName, String password) throws UserNotFoundException, WrongPasswordException {
        User user = findByName(userName);
        if (user == null) {
            throw new UserNotFoundException();
        }

        if (!encoder.matches(password, user.getUserPassword())) {
            throw new WrongPasswordException();
        }

        return user;
    }
}

