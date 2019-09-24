package spring.demo.services;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.demo.dto.UserDTO;
import spring.demo.entities.Room;
import spring.demo.entities.User;

import java.io.IOException;
import java.util.List;

@Component
public interface UserServicee {

    User create(UserDTO userdto);
    User remove(UserDTO userdto);
    User findUserById(Integer id);
    User findUserByUsernameAndPassword(String username, String password);
    List<User> getAll();

    //user role 0/user 1/admin

    void generatePdf(String roomid, String hotelid);
    void sendEmails(String mail);

    void raportHotel() throws IOException;
    User update(String id, UserDTO userDTO);

    void createFile() throws IOException;

}
