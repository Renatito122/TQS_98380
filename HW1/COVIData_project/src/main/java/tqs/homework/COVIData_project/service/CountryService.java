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
        System.out.println("worlddddddddddddddddd");

        ArrayList<Country> africa = getCountriesByContinent("africa");
        ArrayList<Country> northAmerica =  getCountriesByContinent("northamerica");
        ArrayList<Country> southAmerica =  getCountriesByContinent("southamerica");
        ArrayList<Country> australia =  getCountriesByContinent("australia");
        ArrayList<Country> europe = getCountriesByContinent("europe");
        ArrayList<Country> asia = getCountriesByContinent("asia");
        System.out.println(world);
        world.addAll(africa);
        world.addAll(northAmerica);
        world.addAll(southAmerica);
        world.addAll(europe);
        System.out.println(world);

        world.addAll(asia);
        world.addAll(australia);

        System.out.println(world);
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
            Long pop_long = Long.valueOf(population);

            Country newPlace = new Country(iso, country, country, continent, pop_long, null);
            
            if (continents.contains(newPlace) == false){
                continents.add(newPlace);
            }


        }
        return continents;

       
    }


    public Country getPlaceByCountryName(String country){

        Country selectedCountry = new Country();
        System.out.println("here");
        try {
			ArrayList<Country> world = getAllCountries();
            System.out.println("hi");
            System.out.println(world);
            for (Country p : world) {
                if (p.getName() == country){
                    selectedCountry = p;
                    System.out.println("A RESPOSTA E");
                    System.out.println(selectedCountry);

                }
            } 
		} catch (IOException | URISyntaxException | InterruptedException e) {
			e.printStackTrace();
		}
        
		return selectedCountry;

    }

   
}
