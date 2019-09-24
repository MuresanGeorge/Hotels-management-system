package spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.demo.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
