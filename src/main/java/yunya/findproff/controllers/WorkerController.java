package yunya.findproff.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yunya.findproff.DTO.SearchWorkersDTO;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;
import yunya.findproff.models.User;
import yunya.findproff.models.Worker;
import yunya.findproff.repositories.CityRepository;
import yunya.findproff.repositories.SpecializationRepository;
import yunya.findproff.services.UserService;
import yunya.findproff.services.WorkerService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    private final UserService userService;

    private final CityRepository cityRepository;

    private final SpecializationRepository specializationRepository;

    @PostMapping("/save")
    public String saveWorker(Principal principal, @RequestParam int cityId, @RequestParam int specId) {
        User user = userService.getUserByUsername(principal.getName());
        user.setRoles("USER, WORKER");
        System.out.println(principal.getName());
        Worker worker = Worker.builder()
                .user(user)
                .specialization(specializationRepository.getSpecializationById(specId))
                .city(cityRepository.getCityById(cityId))
                .reviews(new ArrayList<>())
                .requests(new ArrayList<>())
                .build();
        user.setWorker(worker);
        userService.changeUser(user);
        return "success";
    }

    @GetMapping("/get-necessary-workers")
    public String getNecessaryWorkers(@RequestParam int cityId, @RequestParam int specId, Model model) {
        City city = cityRepository.getCityById(cityId);
        Specialization specialization = specializationRepository.getSpecializationById(specId);
        List<Worker> workers = workerService.getWorkersBySpecializationAndCity(specialization, city);
        model.addAttribute("workers", workers);
        System.out.println(workers);
        return "workers";
    }

}
