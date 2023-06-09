package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.service.userService.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController extends AbstractRestController<User, Long> {
    UserRestController(UserService userService) {
        this.service = userService;
    }
}
