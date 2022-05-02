package tqs.homework.COVIData_project.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import tqs.homework.COVIData_project.model.COVIData;
import tqs.homework.COVIData_project.cache.Cache;

@Service
public class COVIDataService {
    
    private ArrayList<COVIData> allStats = new ArrayList<>();

    private final Cache cache = new Cache(5 * 60L);


    public ArrayList<COVIData> getCurrentCovidData(String countryId) throws InterruptedException, IOException {

        HandlingRequestsService handler = new HandlingRequestsService();
        String countryIdString = String.valueOf(countryId);
        COVIData result = cache.getRequest(countryIdString);
        if (countryId.equals("")) {
            String endpoint = "covid-ovid-data/sixmonth/" ;
            String data1 = handler.connectAPI(endpoint);
            JSONArray jsonArray = new JSONArray(data1);
            
            JSONObject objectJSON = (JSONObject) jsonArray.get(0);
            COVIData cdata = analysing(objectJSON);
            if (allStats.contains(cdata) == false) {
                allStats.add(cdata);
            }
        }

        else {

            String endpoint = "covid-ovid-data/sixmonth/" + countryId;
            String data2 = handler.connectAPI(endpoint);
            JSONArray jsonArray2 = new JSONArray(data2);

            JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(0);
            COVIData statCountry = analysing(objectJSONCountry);
            allStats.add(statCountry);

        }
        cache.storeRequest(countryIdString, result);
        return allStats;
    }

    public ArrayList<COVIData> getCovidDataByDay(String countryId, String day) throws InterruptedException, IOException {

        HandlingRequestsService handler = new HandlingRequestsService();
        String key =  countryId + "," + day;
        COVIData result = cache.getRequest(key);

        if (countryId.equals("")) {
            String endpoint = "covid-ovid-data/sixmonth/" ;
            String data1 = handler.connectAPI(endpoint);
            JSONArray jsonArray = new JSONArray(data1);
            
            JSONObject objectJSON = (JSONObject) jsonArray.get(0);
            COVIData cdata = analysing(objectJSON);
            if (allStats.contains(cdata) == false) {
                allStats.add(cdata);
            }
        }

        else {

            String endpoint = "covid-ovid-data/sixmonth/" + countryId;
            String data2 = handler.connectAPI(endpoint);
            JSONArray jsonArray2 = new JSONArray(data2);

            JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(0);
            COVIData statCountry = analysing(objectJSONCountry);
            allStats.add(statCountry);

        }
        cache.storeRequest(key, result);
        return allStats;
    }


    public COVIData analysing(JSONObject obj) {

        String country = obj.get("Country").toString();
        String countryId = obj.get("id").toString();
        Integer totalCases = Integer.parseInt(obj.get("total_cases").toString());
        Integer newCases = Integer.parseInt(obj.get("new_cases").toString());
        Integer totalDeaths = Integer.parseInt(obj.get("total_deaths").toString());
        Integer newDeaths = Integer.parseInt(obj.get("new_deaths").toString());
        Integer newTests = Integer.parseInt(obj.get("new_tests").toString());
        Integer totalTests = Integer.parseInt(obj.get("total_tests").toString());
        String date = obj.get("date").toString();

        COVIData stat = new COVIData(countryId, country, totalCases, newCases, totalDeaths, newDeaths,
                totalTests, newTests, date);

        return stat;
    }
}
