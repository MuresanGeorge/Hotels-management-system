package spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.demo.dto.HotelDTO;
import spring.demo.dto.RoomDTO;
import spring.demo.dto.UserDTO;
import spring.demo.entities.Hotel;
import spring.demo.entities.Room;
import spring.demo.entities.User;
import spring.demo.services.HotelService;
import spring.demo.services.RoomService;
import spring.demo.services.UserServicee;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserServicee userServicee;

    @Autowired
    HotelService hotelService;

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/addUser", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public User createUser(@RequestBody UserDTO userDTO){
        return userServicee.create(userDTO);
    }//verificat

    @RequestMapping(value = "/deleteUser", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public User deleteUser(@RequestBody UserDTO userDTO){
        return userServicee.remove(userDTO);
    }//verificat

    @RequestMapping(value = "/updateUser/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id, @RequestBody UserDTO userDTO){//verificat
        return userServicee.update(id, userDTO);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userServicee.getAll();
    }//verificat
    //partea crud pe receptioneri .........


    @RequestMapping(value = "/addHotel", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public Hotel createHotel(@RequestBody HotelDTO hotelDTO){
        return hotelService.create(hotelDTO);
    }//verificat

    @RequestMapping(value = "/deleteHotel/{id}",  method = RequestMethod.POST)
    public void deleteHotel( @PathVariable String id){
        hotelService.remove(id);
    }//verificat

    @RequestMapping(value = "/updateHotel", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public Hotel updateHotel(@RequestBody HotelDTO hotelDTO){
        return hotelService.update(hotelDTO);
    }//verificat

    @RequestMapping(value = "/getAllHotels", method = RequestMethod.GET)
    public List<Hotel> getAllHotels(){
        return hotelService.getAll();
    }//verificat
    //partea crud pe hoteluri .......

    @RequestMapping(value = "/addRoom", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public Room createRoom(@RequestBody RoomDTO roomDTO){
        return roomService.create(roomDTO);
    }//verificat

    @RequestMapping(value = "/deleteRoom/{id}",  method = RequestMethod.POST)//verificata
    public void deleteRoom( @PathVariable String id){
        roomService.remove(id);
    }

    @RequestMapping(value = "/updateRoom", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
    public Room updateRoom(@RequestBody RoomDTO roomDTO){
        return roomService.update(roomDTO);
    }//verificata

    @RequestMapping(value = "/getAllRooms",  method = RequestMethod.GET)
    public List<Room> getAllRooms(){
        return roomService.getAll();
    }//verificata
    //partea crud pe camere

    //generare raport cu inscari totale pe buton
    @RequestMapping(value = "/raportIncasari", method = RequestMethod.POST)
    public void generareRaport() throws IOException {
      userServicee.raportHotel();
    }//si asta am veriricat numai ca nu stiu unde se genereaza ...acum stiu(D/hotel).




}
