package tqs.homework.COVIData_project.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country  {

    @Id
    private String id;
    private String name;
    private String text;
    private String continent;
    private Long population;
    private COVIData data;

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", text='" + getText() + "'" +
            ", continent='" + getContinent() + "'" +
            ", population='" + getPopulation() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }
    
}
