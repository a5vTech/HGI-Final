package dk.hgigym.controller;

import dk.hgigym.model.Request;
import dk.hgigym.model.User;
import dk.hgigym.model.UserRequest;
import dk.hgigym.repository.RequestRepository;
import dk.hgigym.repository.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRequestRepository userRequestRepository;

    @GetMapping("/board")
    public String board(Model model) {
        List<UserRequest> userRequests =  userRequestRepository.findAllByIsRequester(true);

        model.addAttribute("userRequestList",userRequests);
        return "board";
    }
}
