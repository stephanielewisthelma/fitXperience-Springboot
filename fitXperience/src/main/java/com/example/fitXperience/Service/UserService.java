package com.example.fitXperience.Service;

import com.example.fitXperience.Dto.RegisterRequest;
import com.example.fitXperience.Model.User;

public interface UserService {
    User register(RegisterRequest request);

    User findByEmail(String email);
}