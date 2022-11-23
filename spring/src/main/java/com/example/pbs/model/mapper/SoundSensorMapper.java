package com.example.pbs.model.mapper;

import com.example.pbs.model.dao.SoundSensor;
import com.example.pbs.model.dto.request.SoundSensorRequest;
import com.example.pbs.model.dto.response.SoundSensorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.util.Date;

@Mapper(componentModel = "spring", imports = {Date.class, Timestamp.class})
public abstract class SoundSensorMapper {

    @Mapping(target = "dateReceived", expression = "java(new Timestamp(new Date().getTime()))")
    public abstract SoundSensor soundSensorRequestToSoundSensor(SoundSensorRequest soundSensorRequest);

    public abstract SoundSensorResponse soundSensorToSoundSensorResponse(SoundSensor soundSensor);
}