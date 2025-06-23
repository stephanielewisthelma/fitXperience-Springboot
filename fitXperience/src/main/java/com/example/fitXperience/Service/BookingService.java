package com.example.fitXperience.Service;


import com.example.fitXperience.Dto.BookingRequest;
import com.example.fitXperience.Model.Booking;

import java.util.List;

public interface BookingService {
    Booking bookPackage(BookingRequest request);
    List<Booking> getUserBookings(Long userId);
}