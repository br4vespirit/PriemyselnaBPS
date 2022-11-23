package com.example.pbs.model.mapper;

import com.example.pbs.model.dao.TemperatureSensor;
import com.example.pbs.model.dto.request.TemperatureSensorRequest;
import com.example.pbs.model.dto.response.TemperatureSensorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.util.Date;

@Mapper(componentModel = "spring", imports = {Date.class, Timestamp.class})
public abstract class TemperatureSensorMapper {

    @Mapping(target = "dateReceived", expression = "java(new Timestamp(new Date().getTime()))")
    public abstract TemperatureSensor temperatureSensorRequestToTemperatureSensor(TemperatureSensorRequest temperatureSensorRequest);

    public abstract TemperatureSensorResponse temperatureSensorToTemperatureSensorResponse(TemperatureSensor temperatureSensor);
}