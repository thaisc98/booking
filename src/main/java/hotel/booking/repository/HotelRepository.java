package hotel.booking.repository;

import hotel.booking.model.Hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel,Long> {
    List<Hotel> findAll();
    Hotel findHotelById(long hotelId);
}
