package org.example.devsoc25.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.devsoc25.SensorData;
import org.example.devsoc25.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
@RequestMapping("/uno")
public class ArduinoController {
    private final ArduinoService arduinoService;

    public ArduinoController(ArduinoService arduinoService) {
        this.arduinoService = arduinoService;
    }

    @PostMapping("/{plantid}/data")
    public HttpStatus logInfo(@RequestBody SensorData sensorData,
                              @PathVariable long plantid)
    {
        arduinoService.saveData(sensorData,plantid);
        //float type=(sensorData.getAmbient_Temperature());
        System.out.println(plantid+" "+sensorData.toString());
        return HttpStatus.OK;
    }
}
