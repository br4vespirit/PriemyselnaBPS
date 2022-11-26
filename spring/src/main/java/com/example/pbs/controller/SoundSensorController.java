package com.example.pbs.controller;

import com.example.pbs.model.dto.request.SoundSensorRequest;
import com.example.pbs.model.dto.response.SoundSensorResponse;
import com.example.pbs.service.SoundSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sound-sensor")
public class SoundSensorController {

    private final SoundSensorService soundSensorService;

    @PostMapping
    public ResponseEntity<SoundSensorResponse> save(@RequestBody SoundSensorRequest soundSensorRequest) {
        SoundSensorResponse response = soundSensorService.saveData(soundSensorRequest);
        return response == null ? new ResponseEntity<>(null,  HttpStatus.CONFLICT) :
                new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<SoundSensorResponse>> get() {
        return new ResponseEntity<>(soundSensorService.getTopTwenty(), HttpStatus.OK);
    }
}