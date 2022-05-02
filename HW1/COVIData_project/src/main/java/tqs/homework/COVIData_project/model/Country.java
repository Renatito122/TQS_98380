package tqs.homework.COVIData_project.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Country  {

    @Id
    private String id;
    private String name;
    private String text;
    private String continent;
    private Integer population;


    public Country(String id, String name, String text, String continent, Integer population) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.continent = continent;
        this.population = population;
    }


    public Country() {
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", text='" + getText() + "'" +
            ", continent='" + getContinent() + "'" +
            ", population='" + getPopulation() + "'" +
            "}";
    }
    
}
