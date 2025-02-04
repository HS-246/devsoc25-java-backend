package org.example.devsoc25.service;

import org.example.devsoc25.SensorData;
import org.example.devsoc25.entity.Plant;
import org.example.devsoc25.repository.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class ArduinoService {

    private final PlantRepository plantRepository;

    public ArduinoService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public void saveData (SensorData data, long plantid) {
        Plant plant = plantRepository.findById(plantid).get();

        return;
    }
}
