package hotel.booking.controller;

import hotel.booking.model.Reservation;
import hotel.booking.repository.HotelRepository;
import hotel.booking.repository.ReservationRepository;
import hotel.booking.repository.RoomRepository;
import hotel.booking.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ReservationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @MockBean
    private ReservationRepository reservationRepository;

    @MockBean
    private RoomRepository roomRepository;

    @MockBean
    private HotelRepository hotelRepository;



    @Test
    public void getReservationsByUserId() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setHotelId(1);
        reservation.setRoomId(1);
        reservation.setStatus("ACTIVE");
        reservation.setCheckIn(LocalDateTime.now());
        reservation.setCheckOut(LocalDateTime.now().plusDays(2));

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);

        when(reservationService.findReservationsByReservedBy(1)).thenReturn(any());
        when(reservationRepository.findReservationsByReservedBy(1)).thenReturn(reservations);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservation/by-user/{id}", 1))
                .andExpect(status().isOk());
    }


}
