package com.example.pbs.controller;

import com.example.pbs.model.dto.request.HumiditySensorRequest;
import com.example.pbs.model.dto.response.HumiditySensorResponse;
import com.example.pbs.service.HumiditySensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/humidity-sensor")
public class HumiditySensorController {

    private final HumiditySensorService humiditySensorService;

    @PostMapping
    public ResponseEntity<HumiditySensorResponse> save(@RequestBody HumiditySensorRequest humiditySensorRequest) {
        HumiditySensorResponse response = humiditySensorService.saveData(humiditySensorRequest);
        return response == null ? new ResponseEntity<>(null,  HttpStatus.CONFLICT) :
                new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HumiditySensorResponse>> get() {
        return new ResponseEntity<>(humiditySensorService.getTopTwenty(), HttpStatus.OK);
    }
}