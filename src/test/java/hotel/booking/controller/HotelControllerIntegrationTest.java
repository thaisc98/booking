package hotel.booking.controller;

import hotel.booking.model.Hotel;
import hotel.booking.repository.HotelRepository;
import hotel.booking.repository.RoomRepository;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class HotelControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomRepository roomRepository;

    @MockBean
    private HotelRepository hotelRepository;


    @Test
    public void getAllHotels() throws Exception {
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotel.setAvailableRooms(20);
        hotel.setName("Royal");
        hotel.setKeyCountry("PR");

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);

        when(hotelRepository.findAll()).thenReturn(hotels);

        mockMvc.perform(MockMvcRequestBuilders.get("/hotels"))
                .andExpect(status().isOk());
    }

}
