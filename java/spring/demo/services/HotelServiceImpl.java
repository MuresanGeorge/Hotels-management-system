package spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.dto.HotelDTO;
import spring.demo.entities.Hotel;
import spring.demo.repositories.HotelRepository;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel create(HotelDTO hotelDTO) {
        Hotel hotel1 = new Hotel();
        hotel1.setName(hotelDTO.getName());
        hotel1.setId(hotelDTO.getId());

        return hotelRepository.save(hotel1);
    }

    @Override
    public void remove(String id) {
        Hotel hotel = hotelRepository.findOne(Integer.parseInt(id));
        System.out.println(hotel);
        hotelRepository.delete(hotel);

    }

    @Override
    public Hotel findHotelById(Integer id) {
        return hotelRepository.findOne(id);
    }

    @Override
    public Hotel findHotelByName(String name) {
        Hotel hotel= null;
        List<Hotel> hotels;
        hotels = getAll();

        for (Hotel h1:hotels) {
            if(h1.getName().equals(name))
            {
                hotel.setName(name);
            }
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel update(HotelDTO hotelDTO) {
        Hotel hotel = hotelRepository.findOne(hotelDTO.getId());

        hotel.setName(hotelDTO.getName());

        return hotelRepository.save(hotel);
    }
}
