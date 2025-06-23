package com.example.fitXperience.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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

      public Booking() {
      }

      public Booking(Long id, User user, Package gymPackage, LocalDate bookingDate, boolean paid) {
          this.id = id;
          this.user = user;
          this.gymPackage = gymPackage;
          this.bookingDate = bookingDate;
          this.paid = paid;
      }

      public Long getId() {
          return id;
      }

      public void setId(Long id) {
          this.id = id;
      }

      public User getUser() {
          return user;
      }

      public void setUser(User user) {
          this.user = user;
      }

      public Package getGymPackage() {
          return gymPackage;
      }

      public void setGymPackage(Package gymPackage) {
          this.gymPackage = gymPackage;
      }

      public LocalDate getBookingDate() {
          return bookingDate;
      }

      public void setBookingDate(LocalDate bookingDate) {
          this.bookingDate = bookingDate;
      }

      public boolean isPaid() {
          return paid;
      }

      public void setPaid(boolean paid) {
          this.paid = paid;
      }
  }


