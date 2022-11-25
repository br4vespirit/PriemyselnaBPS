package com.example.pbs.controller;

import com.example.pbs.model.dto.request.TemperatureSensorRequest;
import com.example.pbs.model.dto.response.TemperatureSensorResponse;
import com.example.pbs.service.TemperatureSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temperature-sensor")
public class TemperatureSensorController {

    private final TemperatureSensorService temperatureSensorService;

    @PostMapping
    public ResponseEntity<TemperatureSensorResponse> save(@RequestBody TemperatureSensorRequest temperatureSensorRequest) {
        System.out.println(temperatureSensorRequest);
        TemperatureSensorResponse response = temperatureSensorService.saveData(temperatureSensorRequest);
        return response == null ? new ResponseEntity<>(null,  HttpStatus.CONFLICT) :
                new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TemperatureSensorResponse>> get() {
        return new ResponseEntity<>(temperatureSensorService.getTopTwenty(), HttpStatus.OK);
    }
}
