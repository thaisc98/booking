package hotel.booking.service;

import hotel.booking.model.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {

    Reservation save(Reservation reservation);
    Reservation update(Reservation reservation, long reservationId);
    Reservation cancel(long reservationId);
}
