package hotel.booking.controller;

import hotel.booking.model.Hotel;
import hotel.booking.model.Room;
import hotel.booking.repository.HotelRepository;
import hotel.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class HotelController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return new ResponseEntity<>(Objects.nonNull(hotels) ? hotels : null, HttpStatus.OK);
    }

    @GetMapping("/hotel/rooms-available")
    public ResponseEntity<List<Room>> getAllAvailableRoomsByHotelId(@RequestBody Hotel hotel){
        List<Room> rooms = roomRepository.findRoomsByHotelIdAndStatusEquals(hotel.getId(), "AVAILABLE");
        return new ResponseEntity<>(Objects.nonNull(rooms) ? rooms : null, HttpStatus.OK);
    }
}
