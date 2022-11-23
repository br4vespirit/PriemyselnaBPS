package com.example.pbs.model.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class WaterSensorResponse {
    private Long id;
    private boolean isWaterPresent;
    private Timestamp dateReceived;
}
