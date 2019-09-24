package spring.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.demo.dto.ReservationDTO;
import spring.demo.entities.Reservation;

import java.util.List;
@Component
public interface ReservationService {

    Reservation create(ReservationDTO reservationDTO);
    void remove(Integer reservationId);
    Reservation findReservationById(Integer id);
    List<Reservation> getAll();
    Reservation update(String id, ReservationDTO reservationDTO);
    void saveReservation(ReservationDTO reservationDTO);

}
