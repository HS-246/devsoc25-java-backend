package org.example.devsoc25.service;

import com.google.gson.Gson;
import org.example.devsoc25.entity.Plant;
import org.example.devsoc25.entity.User;
import org.example.devsoc25.repository.PlantRepository;
import org.example.devsoc25.repository.UserRepository;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
@Service
public class PlantService {
    private static final Logger log = Logger.getLogger(UserService.class.getName());
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    public PlantService(PlantRepository plantRepository, UserRepository userRepository) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
    }


    public Plant savePlant(Plant plant,long userId) throws URISyntaxException, IOException, InterruptedException {
        Optional<User> user = userRepository.findById(userId);
        plant.setUser(user.get());
//
//        Gson gson = new Gson();
//        String jsonRequest = gson.toJson(plant.getImage());
//
//        HttpRequest request= HttpRequest.newBuilder()
//                .uri(new URI("${AI_URL}/image-classify"))
//                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
//                .build();
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        HttpResponse<String> response=httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        String plantName = gson.fromJson(response.body(),String.class);
//        plant.setName(plantName);

        return plantRepository.save(plant);
    }

    public List<Plant> getAll(long userid) {
        Optional<List<Plant>> plants =plantRepository.findAllByUserUserid(userid);
        //log.info(plants.get().toString());
        return plants.get();
    }
}
