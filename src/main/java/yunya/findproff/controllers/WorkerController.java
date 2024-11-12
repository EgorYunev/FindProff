package yunya.findproff.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yunya.findproff.DTO.SearchWorkersDTO;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;
import yunya.findproff.models.Worker;
import yunya.findproff.services.WorkerService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerService workerService;

    @GetMapping("get-necessary-workers")
    public String getNecessaryWorkers(SearchWorkersDTO dto, Model model) {
        City city = dto.getCity();
        Specialization specialization = dto.getSpecialization();
        List<Worker> workers = workerService.getWorkersBySpecializationAndCity(specialization, city);
        model.addAttribute(workers);
        return "workers";
    }

}
