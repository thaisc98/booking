package hotel.booking.repository;

import hotel.booking.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Reservation findById(long reservationId);
    List<Reservation> findReservationsByReservedBy(long userId);

}
