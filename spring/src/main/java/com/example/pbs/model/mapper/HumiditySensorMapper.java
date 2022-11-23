package com.example.pbs.model.mapper;

import com.example.pbs.model.dao.HumiditySensor;
import com.example.pbs.model.dto.request.HumiditySensorRequest;
import com.example.pbs.model.dto.response.HumiditySensorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.util.Date;

@Mapper(componentModel = "spring", imports = {Date.class, Timestamp.class})
public abstract class HumiditySensorMapper {

    @Mapping(target = "dateReceived", expression = "java(new Timestamp(new Date().getTime()))")
    public abstract HumiditySensor humiditySensorRequestToHumiditySensor(HumiditySensorRequest humiditySensorRequest);

    public abstract HumiditySensorResponse humiditySensorToHumiditySensorResponse(HumiditySensor humiditySensor);
}