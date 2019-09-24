package spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.demo.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
