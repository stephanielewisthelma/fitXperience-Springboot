package com.example.fitXperience.Service.Impl;

import com.example.fitXperience.Model.Booking;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final PackageRepository packageRepository;

    @Autowired
    public BookingServiceImpl(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            PackageRepository packageRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.packageRepository = packageRepository;
    }

    @Override
    public Booking bookPackage(BookingRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Package pkg = packageRepository.findById(request.getPackageId())
                .orElseThrow(() -> new EntityNotFoundException("Package not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setGymPackage(pkg);
        booking.setBookingDate(LocalDate.now());
        booking.setPaid(request.isPaid());

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User with ID " + userId + " does not exist");
        }
        return bookingRepository.findByUserId(userId);
    }
}

