package yunya.findproff.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/save/{city}/{spec}")
    public String saveWorker(Principal principal, City city, Specialization spec) {
        User user = userService.getUserByUsername(principal.getName());
        Worker worker = Worker.builder()
                .user(user)
                .specialization(spec)
                .city(city)
                .reviews(new ArrayList<>())
                .requests(new ArrayList<>())
                .build();
        return "success";
    }

    @GetMapping("/get-necessary-workers")
    public String getNecessaryWorkers(@ModelAttribute SearchWorkersDTO dto, Model model) {
        City city = cityRepository.getCityByName(dto.getCity());
        Specialization specialization = specializationRepository.getSpecializationByName(dto.getSpecialization());
        List<Worker> workers = workerService.getWorkersBySpecializationAndCity(specialization, city);
        model.addAttribute("workers", workers);
        return "workers";
    }

}
