package spring.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
