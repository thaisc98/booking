package hotel.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Reversed in.. Depends of the HOTEL ID
    @Column(name = "hotel_id")
    private long hotelId;

    @Column(name = "room_id")
    private long roomId;

    @Column(name = "reserved_by")
    private long reservedBy;

    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @Column(name = "check_out")
    private LocalDateTime checkOut;

    @Column(name = "status")
    private String status;
}
