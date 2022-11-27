package com.example.pbs.controller;

import com.example.pbs.model.dto.request.MotionSensorRequest;
import com.example.pbs.model.dto.response.MotionSensorResponse;
import com.example.pbs.service.MotionSensorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/motion-sensor")
@Slf4j
public class MotionSensorController {

    private final MotionSensorService motionSensorService;

    @PostMapping
    public ResponseEntity<MotionSensorResponse> save(@RequestBody MotionSensorRequest motionSensorRequest) {
        log.info("Motion sensor noticed a motion");
        MotionSensorResponse response = motionSensorService.saveData(motionSensorRequest);
        return response == null ? new ResponseEntity<>(null,  HttpStatus.CONFLICT) :
                new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<MotionSensorResponse>> get() {
        return new ResponseEntity<>(motionSensorService.getTopTwenty(), HttpStatus.OK);
    }
}
