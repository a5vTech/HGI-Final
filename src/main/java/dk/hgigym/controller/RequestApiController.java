package dk.hgigym.controller;

import dk.hgigym.model.Request;
import dk.hgigym.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RequestApiController {

    @Autowired
    private RequestRepository requestRepository;

//    @PostMapping("/createRequest")
//    public RedirectView createRequest(Request request){
//        requestRepository.save(request);
//        return new RedirectView("board");
//    }
//
//    @PutMapping("/editRequest")
//    public RedirectView editRequest(Request request){
//        requestRepository.save(request);
//        return new RedirectView("board");
//    }
//
//    @DeleteMapping("/deleteRequest/{id}")
//    public RedirectView deleteRequest(@PathVariable Long id){
//        requestRepository.deleteRequest(id);
//        return new RedirectView("board");
//    }
}