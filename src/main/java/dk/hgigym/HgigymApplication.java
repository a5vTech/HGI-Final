package dk.hgigym;

import dk.hgigym.model.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
public class HgigymApplication {
    public static void main(String[] args) {
        SpringApplication.run(HgigymApplication.class, args);
    }
}
