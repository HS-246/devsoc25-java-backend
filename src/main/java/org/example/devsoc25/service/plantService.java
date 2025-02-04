package org.example.devsoc25.service;

import org.example.devsoc25.entity.Plant;
import org.example.devsoc25.entity.User;
import org.example.devsoc25.repository.PlantRepository;
import org.example.devsoc25.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class plantService {
    private static final Logger log = Logger.getLogger(UserService.class.getName());
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    public plantService(PlantRepository plantRepository, UserRepository userRepository) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
    }


    public Plant savePlant(Plant plant,long userId) {
        Optional<User> user = userRepository.findById(userId);

        plant.setUser(user.get());

        return plantRepository.save(plant);
    }
}
