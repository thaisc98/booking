package hotel.booking.controller;

import hotel.booking.model.Reservation;
import hotel.booking.repository.ReservationRepository;
import hotel.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ReservationController {

    // Annotation
    @Autowired
    private ReservationService reservationService;


    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservation/by-user/{id}")
    public List<Reservation> getReservationsByUserId(@PathVariable long id){
        List<Reservation> reservations = reservationRepository.findReservationsByReservedBy(id);
        return Objects.nonNull(reservations) ? reservations : null;
    }
    // Save operation
    @PostMapping("/reservation")
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PostMapping("/reservation/cancel/{id}")
    public Reservation cancelReservation(@PathVariable long id) {
        return reservationService.cancel(id);
    }

    @PutMapping("/reservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation newReservation, @PathVariable long id) {
        return reservationService.update(newReservation,id);
    }

}
