package com.example.pbs.service;

import com.example.pbs.model.dao.SoundSensor;
import com.example.pbs.model.dto.request.SoundSensorRequest;
import com.example.pbs.model.dto.response.SoundSensorResponse;
import com.example.pbs.model.mapper.SoundSensorMapper;
import com.example.pbs.repository.SoundSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoundSensorService {

    private final SoundSensorRepository soundSensorRepository;
    private final SoundSensorMapper soundSensorMapper;

    public SoundSensorResponse saveData(SoundSensorRequest soundSensorRequest) {
        if (soundSensorRequest == null)
            return null;
        SoundSensor soundSensor = soundSensorMapper.soundSensorRequestToSoundSensor(soundSensorRequest);
        SoundSensor response = soundSensorRepository.save(soundSensor);
        return soundSensorMapper.soundSensorToSoundSensorResponse(response);
    }

    public List<SoundSensorResponse> getTopTwenty() {
        return soundSensorRepository.findAll()
                .stream()
                .map(soundSensorMapper::soundSensorToSoundSensorResponse)
                .collect(Collectors.toList());
    }
}
