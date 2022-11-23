package com.example.pbs.model.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class TemperatureSensorResponse {
    private Long id;
    private Double temperature;
    private Timestamp dateReceived;
}