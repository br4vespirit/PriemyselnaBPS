package com.example.pbs.model.mapper;

import com.example.pbs.model.dao.MotionSensor;
import com.example.pbs.model.dto.request.MotionSensorRequest;
import com.example.pbs.model.dto.response.MotionSensorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.util.Date;

@Mapper(componentModel = "spring", imports = {Date.class, Timestamp.class})
public abstract class MotionSensorMapper {

    @Mapping(target = "dateReceived", expression = "java(new Timestamp(new Date().getTime()))")
    public abstract MotionSensor motionSensorRequestToMotionSensor(MotionSensorRequest motionSensorRequest);

    public abstract MotionSensorResponse motionSensorToMotionSensorResponse(MotionSensor motionSensor);
}