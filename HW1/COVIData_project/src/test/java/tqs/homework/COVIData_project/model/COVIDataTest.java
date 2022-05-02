package tqs.homework.COVIData_project.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import tqs.homework.COVIData_project.model.COVIData;

public class COVIDataTest {

    @Test
    void getCovidDataTest(){
    
    COVIData southafricastats = new COVIData("zaf", "South Africa", 3603856, 2226, 95022, 117, 0, 0, "2022-01-30");

    assertEquals("zaf", southafricastats.getId());
    assertEquals("South Africa", southafricastats.getCountry());
    assertEquals(3603856, southafricastats.getTotalCases());
    assertEquals(2226, southafricastats.getNewCases());
    assertEquals(117, southafricastats.getNewDeaths());
    assertEquals(95022, southafricastats.getTotalDeaths());
    assertEquals(0, southafricastats.getTotalTests());
    assertEquals(0, southafricastats.getNewTests());
    assertEquals("2022-01-30", southafricastats.getDate());

   

    }
    
}
