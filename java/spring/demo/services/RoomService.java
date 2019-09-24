package spring.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.demo.dto.RoomDTO;
import spring.demo.entities.Room;

import java.util.List;
@Component
public interface RoomService {

    Room create(RoomDTO roomDTO);
    void remove(String id);
    Room findRoomById(Integer id);
    boolean availabilityOfRoom(Room room);
    List<Room> getAll();
    Room update(RoomDTO roomDTO);
}
