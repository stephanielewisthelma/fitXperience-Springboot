package com.example.fitXperience.Service.Impl;

import com.example.fitXperience.Dto.RegisterRequest;
import com.example.fitXperience.Exception.UserAlreadyExistsException;
import com.example.fitXperience.Model.Role;
import com.example.fitXperience.Model.Roles;
import com.example.fitXperience.Model.User;
import com.example.fitXperience.Repository.RoleRepository;
import com.example.fitXperience.Repository.UserRepository;
import com.example.fitXperience.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistsException("User with email: " + request.getEmail() + " already exists.");
        }
        Roles defaultRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("Default Role not found"));
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setGender(request.getGender());
        user.setRole(Collections.singleton(defaultRole));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }
}

