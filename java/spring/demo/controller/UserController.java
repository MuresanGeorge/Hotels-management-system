package spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spring.demo.dto.EmailDTO;
import spring.demo.dto.ReservationDTO;
import spring.demo.dto.UserDTO;
import spring.demo.entities.Reservation;
import spring.demo.entities.User;
import spring.demo.services.EmailService;
import spring.demo.services.EmailServiceImpl;
import spring.demo.services.ReservationService;
import spring.demo.services.UserServicee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserServicee userServicee;

	@Autowired
    private EmailService emailService;

	private static final String subject = "FeedBack Hotel";
	private static final String text = "Lasa-ne o nota in functie de serviciile oferite";


	@RequestMapping(value = "/login", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public User login(@RequestBody UserDTO entity){//verificat
		System.err.println("Login user: " +  entity.toString());
		return userServicee.findUserByUsernameAndPassword(entity.getUsername(), entity.getPassword());
	}

	@RequestMapping(value = "/addReservation", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public Reservation addReservation(@RequestBody ReservationDTO reservationDTO){//verificat dar nu genereaza niciun pdf ..

		userServicee.generatePdf(""+reservationDTO.getIdRoom(), ""+reservationDTO.getIdHotel());
		return reservationService.create(reservationDTO);
		//userServicee.generatePdf(""+reservationDTO.getIdRoom(), ""+reservationDTO.getIdHotel());
	}

	@RequestMapping(value = "/removeReservation/{id}", method = RequestMethod.POST)
	public void removeReservation(@PathVariable Integer id){
		reservationService.remove(id);
	}//verificat

	@RequestMapping(value = "/updateReservation/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	public Reservation update(@PathVariable String id, @RequestBody ReservationDTO reservationDTO ){//verificat
		return reservationService.update(id, reservationDTO);
	}


	@RequestMapping(value = "/allReservations",  method = RequestMethod.GET)
	public List<Reservation> getAll (){
		return reservationService.getAll();
	}//verificat


	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public void sendEmail( @RequestBody EmailDTO emailDTO){
		System.out.println("aloooo");
		emailService.sendSimpleMessage(emailDTO.getTo(), subject,  text);
	}//ar merge dar cica nu sunt bune datele de login ..





//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
//	public UserDTO getUserById(@PathVariable("id") int id) {
//		return userService.findUserById(id);
//	}
//
//	@RequestMapping(value = "/all", method = RequestMethod.GET)
//	public List<UserDTO> getAllUsers() {
//		return userService.findAll();
//	}
//
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public int insertUser(@RequestBody UserDTO userDTO) {
//		return userService.create(userDTO);
//	}


}

