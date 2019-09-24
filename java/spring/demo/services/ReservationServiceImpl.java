package spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.dto.ReservationDTO;
import spring.demo.entities.Hotel;
import spring.demo.entities.Reservation;
import spring.demo.entities.Room;
import spring.demo.repositories.HotelRepository;
import spring.demo.repositories.ReservationRepository;
import spring.demo.repositories.RoomRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Reservation create(ReservationDTO reservationDTO) {
        Reservation reservation1 = new Reservation();
        Hotel hotel1 = hotelRepository.findOne(reservationDTO.getIdHotel());
        Room room = roomRepository.findOne(reservationDTO.getIdRoom());
        if(room.getAvailability().equals(0))
        {
            reservation1.setIdHotel(hotel1.getId());
            reservation1.setIdRoom(reservationDTO.getIdRoom());
            room.setAvailability(1);
            roomRepository.save(room);
            return reservationRepository.save(reservation1);
        }
        else
            return null;
    }

    @Override
    public void remove(Integer reservationId) {
        List<Reservation> reservations = reservationRepository.findAll();

        for(Reservation r: reservations){
            if(r.getId().equals(reservationId)){
              Room room = roomRepository.findOne(r.getIdRoom());
              room.setAvailability(0);
              roomRepository.save(room);
              reservationRepository.delete(r);
            }
        }
    }

    @Override
    public Reservation findReservationById(Integer id) {
        return reservationRepository.findOne(id);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation update(String id, ReservationDTO reservationDTO) {

        Reservation reservation = reservationRepository.findOne(Integer.parseInt(id));
        //camera veche din rezervare
        Room room1 = roomRepository.findOne(reservation.getIdRoom());
        if(room1.getAvailability() == 1) {
            room1.setAvailability(0);
            roomRepository.save(room1);
        }



        //sa nu-l lase sa faca o rezervare pe o camera deja luata
        Room room2 = roomRepository.findOne(reservationDTO.getIdRoom());
        if(room2.getAvailability() == 0){
            room2.setAvailability(1);
            roomRepository.save(room2);
            reservation.setIdRoom(room2.getId());
            reservation.setIdHotel(reservationDTO.getIdHotel());
            return reservationRepository.save(reservation);

        }else{
            Room room3 = roomRepository.findOne(reservation.getIdRoom());
            room3.setAvailability(1);
            roomRepository.save(room3);
            System.out.println("vezi ca aceea camera e deja ocupata");
            return null;
        }
    }

    @Override
    public void saveReservation(ReservationDTO reservationDTO) {

    }
}
