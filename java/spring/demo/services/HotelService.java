package spring.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.demo.dto.HotelDTO;
import spring.demo.entities.Hotel;

import java.util.List;

@Component
public interface HotelService {

    Hotel create(HotelDTO hotelDTO);
    void remove(String id);
    Hotel findHotelById(Integer id);
    Hotel findHotelByName(String name);
    List<Hotel> getAll();
    Hotel update(HotelDTO hotelDTO);
}
