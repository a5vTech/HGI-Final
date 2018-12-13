package dk.hgigym.controller;

import dk.hgigym.model.Request;
import dk.hgigym.model.User;
import dk.hgigym.repository.RequestRepository;
import dk.hgigym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RequestApiController {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;

    //    @PostMapping("/createRequest")
//    public RedirectView createRequest(Request request){
//        requestRepository.save(request);
//        return new RedirectView("board");
//    }
//
    @PutMapping("/request/accept/{id}")
    public ResponseEntity<String> editRequest(@PathVariable Long id, @RequestParam String email) {
        Request request = requestRepository.findRequest(id);
        User asignee = userRepository.findByEmail(email);
        request.setAssignee(asignee);
        requestRepository.save(request);
        return new ResponseEntity<>("accepted", HttpStatus.OK);
    }
//
//    @DeleteMapping("/deleteRequest/{id}")
//    public RedirectView deleteRequest(@PathVariable Long id){
//        requestRepository.deleteRequest(id);
//        return new RedirectView("board");
//    }


    @GetMapping("/api/getmailinglist")
    public ResponseEntity search() {

        List<User> teacherList = (List<User>) userRepository.findAll();
        List<HashMap> hashMaps = new ArrayList<>();

        for (User teacher : teacherList) {
            HashMap hashMap = new HashMap<>();
            hashMap.put("id", teacher.getEmail());
            hashMap.put("name", teacher.getFirstName() + " " + teacher.getLastName() + " ");
            hashMap.put("email", teacher.getEmail());
            hashMaps.add(hashMap);
        }
        return new ResponseEntity<>(hashMaps, HttpStatus.OK);
    }

}