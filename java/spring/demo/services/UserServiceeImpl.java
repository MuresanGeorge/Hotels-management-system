package spring.demo.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.dto.UserDTO;
import spring.demo.entities.Hotel;
import spring.demo.entities.Room;
import spring.demo.entities.User;
import spring.demo.repositories.HotelRepository;
import spring.demo.repositories.RoomRepository;
import spring.demo.repositories.UserRepository;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceeImpl implements UserServicee {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public User create(UserDTO userdto) {
        User user1 = new User();
        user1.setPassword(userdto.getPassword());
        user1.setUsername(userdto.getUsername());
        user1.setRole(userdto.getRole());
        return userRepository.save(user1);

    }

    @Override
    public User remove(UserDTO userdto) {
//        User user = new User();
//        user.setRole(userdto.getRole());
//        user.setPassword(userdto.getPassword());
//        user.setUsername(userdto.getUsername());
        User user1 = userRepository.findOne(userdto.getId());
        System.out.println(user1);
//        List<User> users = userRepository.findAll();
//        for (User u: users) {
//            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()) && u.getRole() == user.getRole()){
//                userRepository.delete(user);
//            }
//        }
        userRepository.delete(user1);
        return user1;

    }

    //update in functie de username si parola 2 path variable

    @Override
    public User findUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = new User();
        List<User> users;
        users = getAll();
        for (User u : users) {
            if (u.getPassword().equals(password) && u.getUsername().equals(username)) {
                user.setUsername(u.getUsername());
                user.setPassword(u.getPassword());
                user.setRole(u.getRole());
            } else
                System.out.println("vezi ca nu ai gasit user dupa user si parola ");
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    //generare pdf pt partea de user
    @Override
    public void generatePdf(String roomid, String hotelid) {

        Hotel hotel;
        hotel = hotelRepository.findOne(Integer.parseInt(hotelid));

        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("Congrats ! Room " + roomid + "in the hotel " + hotel.getName()+ " is all yours !"));
            document.close();
            writer.close();
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        /*
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Reservation.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
        Chunk chunk = new Chunk("Congrats ! Room " + roomid + "in the hotel " + hotel.getName()+ " is all yours !", font);

        try {
            document.add(chunk);
            System.out.println("Camera rezervata de tine este "+roomid+" in hotelul "+hotel.getName());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();*/

    }

    @Override
    public void sendEmails(String email ) {

    }

    @Override
    public void raportHotel() throws IOException {
        List<Room> rooms = roomRepository.findAll();
        int s = 0;
        for (Room r:rooms) {
            if(r.getAvailability().equals(1)){
            s += Integer.parseInt(r.getCost());
            }
        }
        /*
        Path file = Paths.get("RaportHoteluri.txt");
        Files.write(file, Collections.singleton("Hotelul dumneavoastra are incasari totale de "+ s + " lei"), Charset.forName("UTF-8"));
        System.out.println("S-a generat raport Hotel");
        System.out.println("suma de pe hotel este "+ s);*/

//        File file = null;
//        File dir = new File("D:/");
//        file = File.createTempFile("RaportHotel", ".txt", dir);
//
//        BufferedWriter output = null;
//        try {
//            output = new BufferedWriter(new FileWriter(file));
//            output.write("Hotelul dumneavoastra are incasari totale de "+ s + " lei");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //output.write("Hotelul dumneavoastra are incasari totale de "+ s + " lei");

        BufferedWriter output = null;
        try {
            File file = new File("D:\\hotel\\RaportHotel.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write("Hotelul dumneavoastra are incasari totale de "+ s + " lei");
            System.out.println("S-a generat raport Hotel");
            System.out.println("suma de pe hotel este "+ s);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void createFile() throws IOException {
        File file = null;
        File dir = new File("D:/");
        file = File.createTempFile("RaportHotel", ".txt", dir);
    }


    @Override
    public User update(String id, UserDTO userDTO) {
        User user = userRepository.findOne(Integer.parseInt(id));
        System.out.println(user);
        user.setRole(userDTO.getRole());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }
}
