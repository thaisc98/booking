package hotel.booking.controller;

import hotel.booking.model.Reservation;
import hotel.booking.repository.ReservationRepository;
import hotel.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable long id){
        List<Reservation> reservations = reservationRepository.findReservationsByReservedBy(id);
        return new ResponseEntity<>(Objects.nonNull(reservations) ? reservations : null, HttpStatus.OK);
    }

    /***
     * Reserve a hotel room for a user
     * @param reservation entity
     * @return the same object of reservation
     */
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.save(reservation), HttpStatus.OK);
    }

    /***
     * Cancel a reservation
     * @param id reservation id
     * @return object of reservation with the status "CANCELLED"
     */
    @PostMapping("/reservation/cancel/{id}")
    public ResponseEntity<Reservation> cancelReservation(@PathVariable long id) {
        return new ResponseEntity<>(reservationService.cancel(id), HttpStatus.OK);
    }

    /***
     * Modify a reservation
     * @param newReservation object
     * @param id of the reservation
     * @return the modified reservation
     */
    @PutMapping("/reservation/{id}")
    public  ResponseEntity<Reservation> updateReservation(@RequestBody Reservation newReservation, @PathVariable long id) {
        return new ResponseEntity<>(reservationService.update(newReservation, id), HttpStatus.OK);
    }

}
