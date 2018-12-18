package dk.hgigym.controller;

import dk.hgigym.model.SmtpMailSender;
import dk.hgigym.model.User;
import dk.hgigym.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    SmtpMailSender mailSender;


    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

//    @ResponseBody
//    @GetMapping("/createTestUser")
//    public String createTestUser() throws Exception {
//        User user = userRepository.findByEmail("instructor@hgi.dk");
////        User user = new User();
////        user.setEmail("janni@jensen-dahm.dk");
////        user.setFirstName("Janni");
////        user.setLastName("TESTER");
////        user.setRole("ROLE_INSTRUCTOR");
////        user.setEnabled(true);
//        user.setPassword(passwordEncoder.encode("1234"));
//        userRepository.save(user);
//
////        mailSender.sendMail("jesper2604@gmail.com", "Test ", "This is message");
////        mailSender.sendMail("mikkelkoksen@gmail.com", "Test ", "This is message");
//
////        return "user created with email and pass \nEmail:" + user.getEmail() + "\nPass: 1234";
//        return "Send a mail";
//    }
}
