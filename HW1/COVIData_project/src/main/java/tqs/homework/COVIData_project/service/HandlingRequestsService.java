package tqs.homework.COVIData_project.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import tqs.homework.COVIData_project.model.*;

@Service
public class HandlingRequestsService {
 
    String apiKey = "83ebc5ac34mshac352a8a3133523p1b3d36jsn1b2ad84e5bc6";
    String apiURL = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/";
    String apiHost = "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com";
    String endpoint;

    private CloseableHttpClient client;

    public String connectAPI(String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiURL + endpoint))
            .header("X-RapidAPI-Host", apiHost)
            .header("X-RapidAPI-Key", apiKey)
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
        
    }

    public HandlingRequestsService() throws InterruptedException {
        this.client = HttpClients.createDefault();
    }

    public ArrayList<String> getCountries() throws IOException, URISyntaxException, InterruptedException {
        endpoint = "npm-covid-data/countries-name-ordered";
        String data = connectAPI(endpoint);
        JSONArray jsonArray = new JSONArray(data);
        ArrayList<String> countries = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectJSON =  (JSONObject) jsonArray.get(i);
            String c = objectJSON.get("Country").toString();
            countries.add(c);
        }
        return countries;

       
    }



}
