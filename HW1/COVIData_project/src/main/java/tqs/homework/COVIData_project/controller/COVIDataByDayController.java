package tqs.homework.COVIData_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tqs.homework.COVIData_project.model.Keys;

@Controller
@RequestMapping({"/by-day"})
public class COVIDataByDayController {

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("keys", new Keys());
        return "by-day";
    }

    @PostMapping
    public String showMetrics(Keys keys, Model model) {
        model.addAttribute("country_iso", keys.getCountry().getId());
        model.addAttribute("day", keys.getDay());
        return "covid-data-by-day";
    }
}
