package spring.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cost")
    private String cost;

    @Column(name = "availability")
    private Integer availability;

    public Room(String cost, Integer availability) {
        this.cost = cost;
        this.availability = availability;
    }

    public Room(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", cost='" + cost + '\'' +
                ", availability=" + availability +
                '}';
    }
}
