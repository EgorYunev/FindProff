package yunya.findproff.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yunya.findproff.DTO.RequestDTO;
import yunya.findproff.models.Request;
import yunya.findproff.models.User;
import yunya.findproff.services.RequestService;
import yunya.findproff.services.UserService;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {

    private final RequestService requestService;

    private final UserService userService;

    @PostMapping("/add")
    public String addRequest(@ModelAttribute RequestDTO dto, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());

        Request request = Request.builder()
                .worker(dto.getWorker())
                .user(user)
                .build();
        requestService.addRequest(request);
        return "success";
    }

    @GetMapping("get-by-username")
    public String getRequestsByUsername(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());

        model.addAttribute(user.getReviews());
        return "reviews";
    }

}
