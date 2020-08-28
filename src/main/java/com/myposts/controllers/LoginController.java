package com.myposts.controllers;

import com.myposts.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/")
public class LoginController {

    @Autowired
    private UsersService userService;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password) {
        try {
            return "Hello! "+ userService.validateUserAuthority(userName, password).getUserName();
        } catch (Exception e) {
            return "failed";
        }
    }
}
