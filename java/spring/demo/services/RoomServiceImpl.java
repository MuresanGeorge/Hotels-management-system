package spring.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.dto.RoomDTO;
import spring.demo.entities.Room;
import spring.demo.repositories.RoomRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room create(RoomDTO roomDTO) {
        Room room1 = new Room();
        room1.setAvailability(roomDTO.getAvailability());
        room1.setCost(roomDTO.getCost());
        room1.setId(roomDTO.getId());
        return roomRepository.save(room1);
    }

    @Override
    public void remove(String id) {
        Room room = roomRepository.findOne(Integer.parseInt(id));
        roomRepository.delete(room);
    }

    @Override
    public Room findRoomById(Integer id) {
        return roomRepository.findOne(id);
    }

    @Override
    public boolean availabilityOfRoom(Room room) {
        boolean ok = false;
        if(room.getAvailability().equals("0")){
            ok = true;
        }
        return ok;
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room update(RoomDTO roomDTO) {
        Room room = roomRepository.findOne((roomDTO.getId()));
        room.setAvailability((roomDTO.getAvailability()));
        room.setCost(roomDTO.getCost());
        return roomRepository.save(room);
    }
}
