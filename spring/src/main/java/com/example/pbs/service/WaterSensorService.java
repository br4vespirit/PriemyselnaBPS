package com.example.pbs.service;

import com.example.pbs.model.dao.WaterSensor;
import com.example.pbs.model.dto.request.WaterSensorRequest;
import com.example.pbs.model.dto.response.WaterSensorResponse;
import com.example.pbs.model.mapper.WaterSensorMapper;
import com.example.pbs.repository.WaterSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WaterSensorService {

    private final WaterSensorRepository waterSensorRepository;
    private final WaterSensorMapper waterSensorMapper;

    public WaterSensorResponse saveData(WaterSensorRequest waterSensorRequest) {
        if (waterSensorRequest == null)
            return null;
        WaterSensor waterSensor = waterSensorMapper.waterSensorRequestToWaterSensor(waterSensorRequest);
        WaterSensor response = waterSensorRepository.save(waterSensor);
        return waterSensorMapper.waterSensorToWaterSensorResponse(response);
    }

    public List<WaterSensorResponse> getTopTwenty() {
        return waterSensorRepository.findTwentyHighest()
                .stream()
                .map(waterSensorMapper::waterSensorToWaterSensorResponse)
                .collect(Collectors.toList());
    }
}