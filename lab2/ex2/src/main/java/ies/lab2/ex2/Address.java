package ies.lab2.ex2;

import java.util.Objects;

public class Address {

    private String road;
    private String city;
    private String state;
    private String zio;
    private String houseNumber;

    public Address (String road, String city, String state, String zio, String houseNumber){
        this.road=road;
        this.city=city;
        this.state=state;
        this.zio=zio;
        this.houseNumber=houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" + "road=" + road + ", city=" + city + ", state=" + state + ", zip=" + zio + ", houseNumber=" + houseNumber + '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(road, city, state, zio, houseNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.road, other.road)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zio, other.zio)) {
            return false;
        }
        if (!Objects.equals(this.houseNumber, other.houseNumber)) {
            return false;
        }
        return true;
    }
    
}
