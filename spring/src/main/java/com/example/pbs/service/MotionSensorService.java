package com.example.pbs.service;

import com.example.pbs.model.dao.MotionSensor;
import com.example.pbs.model.dto.request.MotionSensorRequest;
import com.example.pbs.model.dto.response.MotionSensorResponse;
import com.example.pbs.model.mapper.MotionSensorMapper;
import com.example.pbs.repository.MotionSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotionSensorService {

    private final MotionSensorRepository motionSensorRepository;
    private final MotionSensorMapper motionSensorMapper;

    public MotionSensorResponse saveData(MotionSensorRequest motionSensorRequest) {
        if (motionSensorRequest == null)
            return null;
        MotionSensor motionSensor = motionSensorMapper.motionSensorRequestToMotionSensor(motionSensorRequest);
        MotionSensor response = motionSensorRepository.save(motionSensor);
        return motionSensorMapper.motionSensorToMotionSensorResponse(response);
    }

    public List<MotionSensorResponse> getTopTwenty() {
        return motionSensorRepository.findAll()
                .stream()
                .map(motionSensorMapper::motionSensorToMotionSensorResponse)
                .collect(Collectors.toList());
    }
}