package tqs.homework.COVIData_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tqs.homework.COVIData_project.model.Country;

@Controller
@RequestMapping({"/", "/index", "/by-country"})
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("country", new Country());
        return "index";
    }

    @PostMapping
    public String showMetrics(Country country, Model model) {
        model.addAttribute("country_iso", country.getId());
        return "covidata";
    }
}
