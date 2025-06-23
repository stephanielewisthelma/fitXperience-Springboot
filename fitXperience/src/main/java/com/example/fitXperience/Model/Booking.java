package com.example.fitXperience.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;


    @Entity
    public class Booking {
        @Id
        @GeneratedValue
        private Long id;

        @ManyToOne
        private User user;

        @ManyToOne
        private Package gymPackage;

        private LocalDate bookingDate;
        private boolean paid;
    }


