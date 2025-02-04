package org.example.devsoc25.Controller;

import org.example.devsoc25.entity.Plant;
import org.example.devsoc25.service.plantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class PlantController {

    private final plantService PlantService;

    public PlantController(plantService plantService) {
        this.PlantService = plantService;
    }

    @PostMapping("/{userid}/save")
    public ResponseEntity<?> savePlant(@RequestBody Plant plant,@PathVariable long userid) {
        Plant resplant=PlantService.savePlant(plant,userid);

        return ResponseEntity.ok(resplant);
    }
}
