package tqs.homework.COVIData_project.controller.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import tqs.homework.COVIData_project.model.Country;
import tqs.homework.COVIData_project.service.HandlingRequestsService;
import tqs.homework.COVIData_project.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    @Autowired
    public CountryService service;

    @Autowired
    public HandlingRequestsService handler;

    @GetMapping("/all")
    public ArrayList<Country> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Country> countries = this.service.getAllCountries();
        if (countries == null) {
            return null;
        }
        ArrayList<Country> nameCountries = new ArrayList<>();
        for (Country c : countries) {
            nameCountries.add(c);
        }
        return nameCountries;

    }

    @GetMapping("/{con}")
    public ArrayList<Country> getCountriesByContinent(@PathVariable String con) throws IOException, URISyntaxException, InterruptedException {
        ArrayList<Country> countries = this.service.getCountriesByContinent(con);
        if (countries == null) {
            return null;
        }
        ArrayList<Country> nameCountries = new ArrayList<>();
        for (Country c : countries) {
            nameCountries.add(c);     
        }
        return nameCountries;
    }
    
}
