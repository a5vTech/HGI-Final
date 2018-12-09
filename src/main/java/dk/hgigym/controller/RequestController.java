package dk.hgigym.controller;

import dk.hgigym.model.Request;
import dk.hgigym.model.User;
import dk.hgigym.model.UserRequest;
import dk.hgigym.repository.RequestRepository;
import dk.hgigym.repository.UserRepository;
import dk.hgigym.repository.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Date 04. dec. 2018
 */
@Controller
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRequestRepository userRequestRepository;

    @GetMapping("/createRequest")
    public String createRequest(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "create_request";
    }

    @PostMapping("/createRequest")
    public String createRequest(@ModelAttribute UserRequest userRequest) {
        User currentuser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        userRequest.setRequester(true);
        userRequest.setUser(currentuser);
        requestRepository.save(userRequest.getRequest());
        userRequestRepository.save(userRequest);

        return "redirect:/board";
    }

    @GetMapping("/editRequest/{id}")
    public String editRequest(@PathVariable Long id, Model model) {
        Request request = requestRepository.findRequest(id);
        model.addAttribute(request);
        return "edit_Request";
    }

    @GetMapping("/request/{id}")
    public String request(Model model, @PathVariable Long id) {
       UserRequest userRequest = userRequestRepository.findUserRequest(id);
        model.addAttribute("userRequest", userRequest);
        return "request";
    }

}
