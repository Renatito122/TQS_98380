package tqs.homework.COVIData_project.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import tqs.homework.COVIData_project.model.COVIData;

@Service
public class COVIDataService {
    
    private ArrayList<COVIData> allStats = new ArrayList<>();

    public ArrayList<COVIData> getStatisticsData(String iso) throws InterruptedException, IOException {

        HandlingRequestsService handler = new HandlingRequestsService();
        if (iso.equals("")) {
            String endpoint = "covid-ovid-data/sixmonth/" ;
            String data = handler.connectAPI(endpoint);
            System.out.println(endpoint);
            System.out.println("hahaha");
            JSONArray jsonArray = new JSONArray(data);
            System.out.println(data);
            
            JSONObject objectJSON = (JSONObject) jsonArray.get(0);
            COVIData cdata = analysing(objectJSON);
            if (allStats.contains(cdata) == false) {
                allStats.add(cdata);
            }
            /*
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objectJSON = (JSONObject) jsonArray.get(i);
                COVIData cdata = analysing(objectJSON);
                if (allStats.contains(cdata) == false) {
                    allStats.add(cdata);
                }
            }
            */
        
        }

        else {
            System.out.println("aaa");

            String endpoint = "covid-ovid-data/sixmonth/" + iso;
            System.out.println(endpoint);
            String data2 = handler.connectAPI(endpoint);
            JSONArray jsonArray2 = new JSONArray(data2);
            System.out.println(data2);

            JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(0);
            COVIData statCountry = analysing(objectJSONCountry);
            allStats.add(statCountry);

            /*
            for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject objectJSONCountry = (JSONObject) jsonArray2.get(i);
                COVIData statCountry = analysing(objectJSONCountry);
                allStats.add(statCountry);
            }
            */
        }

        return allStats;
    }


    public COVIData analysing(JSONObject obj) {

        String country = obj.get("Country").toString();
        String placeId = obj.get("id").toString();
        Integer totalCases = Integer.parseInt(obj.get("total_cases").toString());
        Integer newCases = Integer.parseInt(obj.get("new_cases").toString());
        Integer totalDeaths = Integer.parseInt(obj.get("total_deaths").toString());
        Integer newDeaths = Integer.parseInt(obj.get("new_deaths").toString());
        Integer newTests = Integer.parseInt(obj.get("new_tests").toString());
        Integer totalTests = Integer.parseInt(obj.get("total_tests").toString());
        String date = obj.get("date").toString();

        COVIData stat = new COVIData(placeId, country, totalCases, newCases, totalDeaths, newDeaths,
                totalTests, newTests, date);

        return stat;
    }
}
