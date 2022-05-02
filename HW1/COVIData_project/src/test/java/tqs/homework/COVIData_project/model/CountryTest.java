package tqs.homework.COVIData_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import tqs.homework.COVIData_project.model.Country;

public class CountryTest {
    
    Country southafrica = new Country("zaf", "South Africa", "South Africa", "Africa", 60672691);

    @Test
    void getPlaceTest() {

        assertEquals("zaf", southafrica.getId());
        assertEquals("South Africa", southafrica.getName());
        assertEquals("South Africa", southafrica.getName());
        assertEquals("Africa", southafrica.getContinent());
        assertEquals(60672691, southafrica.getPopulation());
       
    }
}
