package tqs.homework.COVIData_project.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import tqs.homework.COVIData_project.model.Country;
import tqs.homework.COVIData_project.model.COVIData;
import tqs.homework.COVIData_project.service.CountryService;
import tqs.homework.COVIData_project.service.COVIDataService;

@WebMvcTest(RestController.class)
public class RestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private COVIDataService covidataService;

    @MockBean
    private CountryService countryService;

    @Test
    void getCountryDataTest() throws Exception {
        ArrayList<COVIData> dataArray = new ArrayList<>();

        COVIData countryCovidData = new COVIData("zaf", "South Africa", 3603856, 2226, 95022, 117, 0, 0, "2022-01-30");

        dataArray.add(countryCovidData);
        
        when(covidataService.getCurrentCovidData(Mockito.anyString())).thenReturn(dataArray);

        mvc.perform(
            get("/api/statistics/SouthAfrica/").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(1)))
            .andExpect(jsonPath("$[0].place", is(countryCovidData.getCountry())));
            
        verify(covidataService, times(1)).getCurrentCovidData("South Africa");

    }

    @Test
    void getAllCountriesTest() throws Exception {
        ArrayList<Country> countryArray = new ArrayList<>();

        Country southafrica = new Country("zaf", "South Africa", "South Africa", "Africa", 60672691);
        Country france = new Country("fra", "France", "France", "Europe", 65537387);
        Country india = new Country("ind", "India", "India", "Asia", 1404791509);

        countryArray.add(southafrica);
        countryArray.add(france);
        countryArray.add(india);

        
        when( countryService.getAllCountries()).thenReturn(countryArray);

        mvc.perform(
            get("/api/countries/all/").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(3)))
            .andExpect(jsonPath("$[0].id", is("zaf")))
            .andExpect(jsonPath("$[0].name", is("South Africa")))
            .andExpect(jsonPath("$[1].id", is("fra")))
            .andExpect(jsonPath("$[2].id", is("ind")));

        verify(countryService, times(1)).getAllCountries();

    }


    @Test
    void getCountriesByContinentTest() throws Exception {
        ArrayList<Country> countryArray = new ArrayList<>();

        Country india = new Country("ind", "India", "India", "Asia", 1404791509);
        Country vietnam = new Country("vnm", "Vietnam", "Vietnam", "Asia", 98938645);
        Country japan = new Country("jpn", "Japan", "Japan", "Asia", 125769179);

        countryArray.add(india);
        countryArray.add(vietnam);
        countryArray.add(japan);

        when( countryService.getCountriesByContinent("Asia")).thenReturn(countryArray);

        mvc.perform(
            get("/api/countries/Asia/").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(3)))
            .andExpect(jsonPath("$[0].continent", is("Asia")))
            .andExpect(jsonPath("$[1].continent", is("Asia")))
            .andExpect(jsonPath("$[2].continent", is("Asia")));
            
        verify(countryService, times(1)).getCountriesByContinent("Asia");

    }
}
