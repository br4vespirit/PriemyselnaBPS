package com.example.pbs.model.mapper;

import com.example.pbs.model.dao.WaterSensor;
import com.example.pbs.model.dto.request.WaterSensorRequest;
import com.example.pbs.model.dto.response.WaterSensorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.util.Date;

@Mapper(componentModel = "spring", imports = {Date.class, Timestamp.class})
public abstract class WaterSensorMapper {

    @Mapping(target = "dateReceived", expression = "java(new Timestamp(new Date().getTime()))")
    public abstract WaterSensor waterSensorRequestToWaterSensor(WaterSensorRequest waterSensorRequest);

    public abstract WaterSensorResponse waterSensorToWaterSensorResponse(WaterSensor waterSensor);
}
