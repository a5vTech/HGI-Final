package dk.hgigym.controller;

import dk.hgigym.model.User;
import dk.hgigym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/testPassword")
    public ResponseEntity<String> passCheck(@RequestParam String oldPass) {
        User currentuser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (passwordEncoder.matches(oldPass, currentuser.getPassword())) {

            return new ResponseEntity<>("MATCH", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NO MATCH", HttpStatus.OK);

        }

    }
}
