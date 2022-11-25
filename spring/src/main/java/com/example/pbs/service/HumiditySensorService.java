package com.example.pbs.service;

import com.example.pbs.model.dao.HumiditySensor;
import com.example.pbs.model.dto.request.HumiditySensorRequest;
import com.example.pbs.model.dto.response.HumiditySensorResponse;
import com.example.pbs.model.mapper.HumiditySensorMapper;
import com.example.pbs.repository.HumiditySensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HumiditySensorService {

    private final HumiditySensorRepository humiditySensorRepository;
    private final HumiditySensorMapper humiditySensorMapper;

    public HumiditySensorResponse saveData(HumiditySensorRequest humiditySensorRequest) {
        if (humiditySensorRequest == null)
            return null;
        HumiditySensor humiditySensor = humiditySensorMapper.humiditySensorRequestToHumiditySensor(humiditySensorRequest);
        HumiditySensor response = humiditySensorRepository.save(humiditySensor);
        return humiditySensorMapper.humiditySensorToHumiditySensorResponse(response);
    }

    public List<HumiditySensorResponse> getTopTwenty() {
        return humiditySensorRepository.findAll()
                .stream()
                .map(humiditySensorMapper::humiditySensorToHumiditySensorResponse)
                .collect(Collectors.toList());

    }
}
