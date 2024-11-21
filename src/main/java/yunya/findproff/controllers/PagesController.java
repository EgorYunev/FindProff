package yunya.findproff.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;
import yunya.findproff.repositories.CityRepository;
import yunya.findproff.repositories.SpecializationRepository;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pages")
public class PagesController {

    private final CityRepository cityRepository;

    private final SpecializationRepository specializationRepository;

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<City> cities = cityRepository.findAll();
        List<Specialization> specializations = specializationRepository.findAll();

        model.addAttribute("cities", cities);
        model.addAttribute("specializations", specializations);
        for (City city : cities) {
            System.out.println(city.getName());
        }
        return "main";
    }

    @GetMapping("/workerForm")
    public String workerForm(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("specializations",specializationRepository.findAll());
        return "workerForm";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

}
