package hotel.booking.repository;

import hotel.booking.model.Hotel;
import hotel.booking.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {

    Room findRoomById(long roomId);
    List<Room> findRoomsByHotelIdAndStatusEquals(long hotelId, String status);

}
