package org.example.devsoc25.service;

import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.devsoc25.SensorData;
import org.example.devsoc25.entity.Plant;
import org.example.devsoc25.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Service
public class ArduinoService {

    private final PlantRepository plantRepository;

    public ArduinoService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Transactional
    public void saveData (SensorData data, long plantid) throws IOException, InterruptedException, URISyntaxException {
        Plant plant = plantRepository.findById(plantid).get();
        data.setSpecies(plant.getName());

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(data);
        //log.info(jsonRequest);
        HttpRequest request= HttpRequest.newBuilder()
                .uri(new URI("${AI_URL}/health-detect"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response=httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String status = gson.fromJson(response.body(),String.class);

        plant.setStatus(status);
        plant.setSensors(data);

        plantRepository.save(plant);
    }
}
