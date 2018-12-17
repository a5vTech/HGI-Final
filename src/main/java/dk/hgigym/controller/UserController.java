package dk.hgigym.controller;

import dk.hgigym.model.Request;
import dk.hgigym.model.User;
import dk.hgigym.repository.RequestRepository;
import dk.hgigym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;





    @GetMapping("/board")
    public String board(Model model) {
        List<Request> requestList = requestRepository.findAllByAssigneeEmailIsNull();
        model.addAttribute("requestList", requestList);
        return "board";
    }

    @GetMapping("/myPage")
    public String myPage(Model model) {
        User currentuser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Request> acceptedRequestsList = requestRepository.findAllByAssigneeEmail(currentuser.getEmail());

        List<Request> myRequestsList = requestRepository.findAllByRequesterEmail(currentuser.getEmail());

        model.addAttribute("acceptedRequestsList", acceptedRequestsList);
        model.addAttribute("myRequestsList", myRequestsList);
        return "my_page";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        return "settings";
    }

    @PostMapping("/settings")
    public String settingsPost(@ModelAttribute User user) {
        if(user.getPassword() != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/settings";
    }


}
