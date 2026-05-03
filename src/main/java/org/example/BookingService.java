package org.example;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
public class BookingService {
    private static final Logger logger = Logger.getLogger(BookingService.class.getName());
    private Repository<Booking> bookings = new  Repository<>();
    public Booking createBooking(String id, Guest guest, Room room) {
        if(id == null || id.isBlank()){
            logger.severe("id cannot be blank");
            throw new BookingException("id cannot be blank");
        }
        if(guest == null) {
            logger.severe("guest cannot be null");
            throw new BookingException("guest cannot be null");
        }
        if(room == null) {
            logger.severe("room cannot be null");
            throw new BookingException("room cannot be null");
        }
        Booking booking = new Booking(id, guest, room);
        bookings.add(booking);
        return booking;
    }
    public void confirmBooking(String id) {
        Booking booking = bookings.findById(id)
                .orElseThrow(() -> {
                    logger.severe("booking with id " + id + " not found");
                    return new BookingException("booking not found");
                });
        if (booking.getStatus() != Status.CREATED) {
            logger.severe("boking can't be created, only CREATED");
            throw new BookingException("booking can't be created");
        }
        booking.setStatus(Status.CONFIRMED);
        logger.info("booking with id " + id + " confirmed");
    }
    public void cancelBooking(String id) {
        Booking booking = bookings.findById(id)
                .orElseThrow(() -> {
                    logger.severe("booking with id " + id + " not found");
                    return new BookingException("booking not found");
                });
        if (booking.getStatus() != Status.CONFIRMED) {
            logger.severe("booking with this status can't be cancelled, only CONFIRMED");
            throw new BookingException("booking can't be cancelled");
        }
        booking.setStatus(Status.CANCELLED);
        logger.info("booking with id " + id + " cancelled");
    }
    public Optional<Booking> findBookingById(String id) {
        return bookings.findById(id);
    }
    public List<Booking> findAllBookings() {
        return bookings.findAll();
    }
}
