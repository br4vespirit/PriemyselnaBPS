package com.example.pbs.service;

import com.example.pbs.model.dao.TemperatureSensor;
import com.example.pbs.model.dto.request.TemperatureSensorRequest;
import com.example.pbs.model.dto.response.TemperatureSensorResponse;
import com.example.pbs.model.mapper.TemperatureSensorMapper;
import com.example.pbs.repository.TemperatureSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TemperatureSensorService {

    private final TemperatureSensorRepository temperatureSensorRepository;
    private final TemperatureSensorMapper temperatureSensorMapper;

    public TemperatureSensorResponse saveData(TemperatureSensorRequest temperatureSensorRequest) {
        if (temperatureSensorRequest == null)
            return null;
        TemperatureSensor temperatureSensor = temperatureSensorMapper.temperatureSensorRequestToTemperatureSensor(temperatureSensorRequest);
        TemperatureSensor response = temperatureSensorRepository.save(temperatureSensor);
        return temperatureSensorMapper.temperatureSensorToTemperatureSensorResponse(response);
    }

    public List<TemperatureSensorResponse> getTopTwenty() {
        return temperatureSensorRepository.findTwentyHighest()
                .stream()
                .map(temperatureSensorMapper::temperatureSensorToTemperatureSensorResponse)
                .collect(Collectors.toList());
    }
}