package tqs.homework.COVIData_project.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;
import tqs.homework.COVIData_project.model.Country;

@Service
public class CountryService {
    
    private HandlingRequestsService handler;
    
    public ArrayList<Country> getAllCountries() throws IOException, URISyntaxException, InterruptedException {
        
        ArrayList<Country> world = new ArrayList<>();

        ArrayList<Country> africa = getCountriesByContinent("africa");
        ArrayList<Country> northAmerica =  getCountriesByContinent("northamerica");
        ArrayList<Country> southAmerica =  getCountriesByContinent("southamerica");
        ArrayList<Country> australia =  getCountriesByContinent("australia");
        ArrayList<Country> europe = getCountriesByContinent("europe");
        ArrayList<Country> asia = getCountriesByContinent("asia");

        world.addAll(africa);
        world.addAll(northAmerica);
        world.addAll(southAmerica);
        world.addAll(europe);
        world.addAll(asia);
        world.addAll(australia);

        return world;

    }
    
    
    public ArrayList<Country> getCountriesByContinent(String continente) throws IOException, URISyntaxException, InterruptedException {
        HandlingRequestsService handler = new HandlingRequestsService();
        String endpoint = "npm-covid-data/" + continente; 
        String data = handler.connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<Country> continents = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String country = objectJSON.get("Country").toString();
            String continent = objectJSON.get("Continent").toString();
            String population = objectJSON.get("Population").toString();
            String iso =  objectJSON.get("ThreeLetterSymbol").toString();
            Integer pop_long = Integer.valueOf(population);

            Country newPlace = new Country(iso, country, country, continent, pop_long);
            
            if (continents.contains(newPlace) == false){
                continents.add(newPlace);
            }


        }
        return continents;

       
    }

   
}
