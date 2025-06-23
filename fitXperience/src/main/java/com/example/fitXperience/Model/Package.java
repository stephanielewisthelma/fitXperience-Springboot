package com.example.fitXperience.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


    @Entity
    public class Package {
        @Id
        @GeneratedValue
        private Long id;
        private String title;
        private String description;
        private Double price;
        private int durationInDays;

        @OneToMany(mappedBy = "gymPackage")
        private List<Booking> bookings = new ArrayList<>();
    }


