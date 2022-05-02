package tqs.homework.COVIData_project.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KeysTest {

    @Test
    public void testSetDay() {
        Keys keys = new Keys();
        String day = "day1";
        keys.setDay(day);
        assertThat(keys.getDay()).isEqualTo(day);
    }

    @Test
    public void testSetCountry() {
        Country country = new Country();
        Keys keys = new Keys();
        keys.setCountry(country);
        assertThat(keys.getCountry()).isEqualTo(country);
    }
}
