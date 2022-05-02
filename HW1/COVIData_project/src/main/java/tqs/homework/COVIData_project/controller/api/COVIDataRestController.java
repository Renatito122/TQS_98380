package tqs.homework.COVIData_project.controller.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import tqs.homework.COVIData_project.exception.ResourceNotFoundException;
import tqs.homework.COVIData_project.model.COVIData;
import tqs.homework.COVIData_project.service.HandlingRequestsService;
import tqs.homework.COVIData_project.service.COVIDataService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/covidata")
public class COVIDataRestController {

    @Autowired
    public COVIDataService covidataService;

    @Autowired
    public HandlingRequestsService handler;

    @GetMapping("/{countryId}")
    public ArrayList<COVIData> getCountriesStatistics(@PathVariable String countryId) throws ResourceNotFoundException, IOException, URISyntaxException, InterruptedException {
        return covidataService.getCurrentCovidData(countryId);
    }

    
}
