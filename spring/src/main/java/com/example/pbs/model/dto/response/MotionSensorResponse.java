package com.example.pbs.model.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class MotionSensorResponse {
    private Long id;
    private String someText;
    private Timestamp dateReceived;
}