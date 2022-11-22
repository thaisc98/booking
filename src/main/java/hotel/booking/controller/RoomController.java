package hotel.booking.controller;

import hotel.booking.model.Hotel;
import hotel.booking.model.Room;
import hotel.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms/available")
    public ResponseEntity<List<Room>> getAllAvailableRoomsByHotelId(@RequestBody Hotel hotel){
        List<Room> rooms = roomRepository.findRoomsByHotelIdAndStatusEquals(hotel.getId(), "AVAILABLE");
        return new ResponseEntity<>(Objects.nonNull(rooms) ? rooms : new ArrayList<>(), HttpStatus.OK);
    }
}
