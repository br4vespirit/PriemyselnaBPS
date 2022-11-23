package com.example.pbs.model.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class SoundSensorResponse {
    private Long id;
    private Double value;
    private Timestamp dateReceived;
}