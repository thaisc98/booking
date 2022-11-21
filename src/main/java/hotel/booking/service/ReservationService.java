package hotel.booking.service;

import hotel.booking.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    Reservation save(Reservation reservation);
    Reservation update(Reservation reservation, long reservationId);
    Reservation cancel(long reservationId);
    List<Reservation> findReservationsByReservedBy(long userId);
}
