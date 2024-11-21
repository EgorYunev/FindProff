package yunya.findproff.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yunya.findproff.DTO.RequestDTO;
import yunya.findproff.models.Request;
import yunya.findproff.models.User;
import yunya.findproff.models.Worker;
import yunya.findproff.repositories.CityRepository;
import yunya.findproff.repositories.SpecializationRepository;
import yunya.findproff.services.RequestService;
import yunya.findproff.services.UserService;
import yunya.findproff.services.WorkerService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;

    private final UserService userService;

    private final WorkerService workerService;

    private final CityRepository cityRepository;

    private final SpecializationRepository specializationRepository;

    @PostMapping("/add")
    public String addRequest(@RequestParam int cityId, @RequestParam int specId, @RequestParam String text, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());

        Request request = Request.builder()
                .user(user)
                .city(cityRepository.getCityById(cityId))
                .specialization(specializationRepository.getSpecializationById(specId))
                .text(text)
                .build();
        requestService.addRequest(request);
        return "success";
    }

    @GetMapping("/get")
    public String getRequestsByUsername(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());

        model.addAttribute("requests", user.getRequests());
        return "getRequests";
    }

    @GetMapping("/find")
    public String findRequestsByCityAndSpecialization(Principal principal, Model model) {
        Worker worker = userService.getUserByUsername(principal.getName()).getWorker();
        List<Request> requests = requestService.getRequestsByCityAndSpec(worker.getCity().getId(), worker.getSpecialization().getId());
        model.addAttribute("requests", requests);

        return "requestsFind";
    }

    @PostMapping("/apply")
    public String applyRequest(@RequestParam int id, Principal principal) {
        Request request = requestService.getRequestById(id);
        User worker = userService.getUserByUsername(principal.getName());
        request.setWorker(worker.getWorker());
        worker.getWorker().getRequests().add(request);
        workerService.changeWorker(worker.getWorker());
        return "success";
    }
}
