package com.example.userservice.service.roleService;

import com.example.userservice.model.Role;
import com.example.userservice.repo.RoleRepository;
import com.example.userservice.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService<Role, Long> implements RoleService {
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.jpaRepository = roleRepository;
    }
}
