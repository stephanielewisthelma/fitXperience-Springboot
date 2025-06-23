package com.example.fitXperience.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
    public class User {
        @Id @GeneratedValue
        private Long id;
        private String name;
        private String email;
        private String password;
        private String phone;
        private String gender;

//        @Enumerated(EnumType.STRING)
//        private Roles role;

        private Set<Roles> role = new HashSet<>();

        // Bookings
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Booking> bookings = new ArrayList<>();

        public User() {
        }

        public User(Long id, String name, String email, String password, String phone, String gender, Set<Roles> role, List<Booking> bookings) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.gender = gender;
            this.role = role;
            this.bookings = bookings;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Set<Roles> getRoles() {
            return role;
        }

        public void setRole(Set<Roles> roles) {
            this.role = roles;
        }

        public List<Booking> getBookings() {
            return bookings;
        }

        public void setBookings(List<Booking> bookings) {
            this.bookings = bookings;
        }
    }


