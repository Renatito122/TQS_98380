package tqs.homework.COVIData_project.model;

import java.lang.annotation.Inherited;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;


public class COVIData {

    private String id;
    private String country;
    private Integer totalCases;
    private Integer newCases;
    private Integer totalDeaths;
    private Integer newDeaths;
    private Integer totalTests;
    private Integer newTests;
    private String date;

    public COVIData(String id, String country, Integer totalCases, Integer newCases, Integer totalDeaths, Integer newDeaths, Integer totalTests, Integer newTests, String date) {
        this.id = id;
        this.country = country;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalTests = totalTests;
        this.newTests = newTests;
        this.date = date;
    }

    public COVIData(){        
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getTotalCases() {
        return this.totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getNewCases() {
        return this.newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Integer getTotalDeaths() {
        return this.totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getNewDeaths() {
        return this.newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getTotalTests() {
        return this.totalTests;
    }

    public void setSix_total_tests(Integer totalTests) {
        this.totalTests = totalTests;
    }

    public Integer getNewTests() {
        return this.newTests;
    }

    public void setNewTests(Integer newTests) {
        this.newTests = newTests;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
