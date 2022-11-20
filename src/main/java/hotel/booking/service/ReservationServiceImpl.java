package hotel.booking.service;

import hotel.booking.model.Hotel;
import hotel.booking.model.Reservation;
import hotel.booking.model.Room;
import hotel.booking.repository.HotelRepository;
import hotel.booking.repository.RoomRepository;
import hotel.booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final long HOURS = 60 * 60 * 1000;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Reservation save(Reservation reservation) {

        //conditions for save a reservation
        //1. Room can be booked 24 hours before the check-in date and no more than 1 month in advance.
        long hoursBetweenDates = getHoursBetweenDates(reservation.getCheckIn());
        long days = ChronoUnit.DAYS.between(LocalDateTime.now(), reservation.getCheckIn());

        if(hoursBetweenDates < 24 || days < -31){
            throw new IllegalArgumentException("Room can be booked 24 hours before the check-in date and no more than 1 month in advance, please try again.");
        }

        //2. A user can book a room for a duration of 1 to 5 days.
        long daysBetween = Duration.between(reservation.getCheckIn(), reservation.getCheckOut()).toDays();
        if(daysBetween == 0 || daysBetween > 5){
            throw new IllegalArgumentException("A user can book a room for a duration of 1 to 5 days, please try again.");
        }

        //3. Room should be available
        Room room = roomRepository.findRoomById(reservation.getRoomId());
        if(room.getStatus().equals("RESERVED")){
            throw new IllegalArgumentException("The room is not available, please choose another more comfortable room.");
        }

        //4. Hotel should have available rooms
        Hotel hotel = hotelRepository.findHotelById(reservation.getHotelId());
        if(hotel.getAvailableRooms() == 0){
            throw new IllegalArgumentException(String.format("The hotel %s has no available rooms, please try again later.", hotel.getName()));
        }

        reservationRepository.save(reservation);

        room.setStatus("RESERVED");
        roomRepository.save(room);

        hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
        hotelRepository.save(hotel);

        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation, long reservationId) {


        return null;
    }

    @Override
    public Reservation cancel(long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);
        // conditions
        // A user cannot cancel a reservation 24 hours before the booked date
        long hoursBetweenDates = getHoursBetweenDates(reservation.getCheckIn());
        if(hoursBetweenDates < 24){
            throw new IllegalArgumentException("Cannot cancel a reservation 24 hours before the booked date, please contact support.");
        }

        reservation.setStatus("CANCELLED");

        Room room = roomRepository.findRoomById(reservation.getRoomId());
        room.setStatus("AVAILABLE");
        roomRepository.save(room);

        Hotel hotel = hotelRepository.findHotelById(reservation.getHotelId());
        hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
        hotelRepository.save(hotel);

        return reservation;
    }

    private long getHoursBetweenDates(LocalDateTime checkInDate) {
        LocalDateTime now = LocalDateTime.now();
        long nowMS = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long bookedDateMS = checkInDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long msBetweenDates = Math.abs(bookedDateMS - nowMS);
        return msBetweenDates / HOURS;
    }

}
