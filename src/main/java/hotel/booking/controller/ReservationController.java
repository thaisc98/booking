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

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    /***
     * Get all reservations/booked by user id
     * @param id is the user id
     * @return list of all reservations
     */
    @GetMapping("/reservation/by-user/{id}")
    public List<Reservation> getReservationsByUserId(@PathVariable long id){
        List<Reservation> reservations = reservationRepository.findReservationsByReservedBy(id);
        return Objects.nonNull(reservations) ? reservations : null;
    }

    /***
     * Reserve a hotel room for a user
     * @param reservation entity
     * @return the same object of reservation
     */
    @PostMapping("/reservation")
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    /***
     * Cancel a reservation
     * @param id reservation id
     * @return object of reservation with the status "CANCELLED"
     */
    @PostMapping("/reservation/cancel/{id}")
    public Reservation cancelReservation(@PathVariable long id) {
        return reservationService.cancel(id);
    }

    /***
     * Modify a reservation
     * @param newReservation object
     * @param id of the reservation
     * @return the modified reservation
     */
    @PutMapping("/reservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation newReservation, @PathVariable long id) {
        return reservationService.update(newReservation, id);
    }

}
