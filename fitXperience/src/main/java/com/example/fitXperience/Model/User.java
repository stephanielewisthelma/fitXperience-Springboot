package com.example.fitXperience.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    @Entity
    public class User {
        @Id @GeneratedValue
        private Long id;
        private String name;
        private String email;
        private String password;
        private String phone;
        private String gender;

        @Enumerated(EnumType.STRING)
        private Role role;

        // Bookings
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Booking> bookings = new ArrayList<>();
    }

}
