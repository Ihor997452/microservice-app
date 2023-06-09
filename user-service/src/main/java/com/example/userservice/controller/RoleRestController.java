package com.example.userservice.controller;

import com.example.userservice.model.Role;
import com.example.userservice.service.roleService.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleRestController extends AbstractRestController<Role, Long> {
    RoleRestController(RoleService roleService) {
        this.service = roleService;
    }
}
