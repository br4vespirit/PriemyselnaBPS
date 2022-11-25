package com.example.pbs.controller;

import com.example.pbs.model.dto.request.WaterSensorRequest;
import com.example.pbs.model.dto.response.WaterSensorResponse;
import com.example.pbs.service.WaterSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/water-sensor")
public class WaterSensorController {

    private final WaterSensorService waterSensorService;

    @PostMapping
    public ResponseEntity<WaterSensorResponse> save(@RequestBody WaterSensorRequest waterSensorRequest) {
        WaterSensorResponse response = waterSensorService.saveData(waterSensorRequest);
        return response == null ? new ResponseEntity<>(null,  HttpStatus.CONFLICT) :
                new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WaterSensorResponse>> get() {
        return new ResponseEntity<>(waterSensorService.getTopTwenty(), HttpStatus.OK);
    }
}