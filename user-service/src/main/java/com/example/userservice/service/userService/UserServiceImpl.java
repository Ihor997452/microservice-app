package com.example.userservice.service.userService;

import com.example.userservice.model.User;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {
    public UserServiceImpl(UserRepository userRepository) {
        this.jpaRepository = userRepository;
    }
}
