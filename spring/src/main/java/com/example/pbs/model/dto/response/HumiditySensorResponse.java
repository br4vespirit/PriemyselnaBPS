package com.example.pbs.model.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class HumiditySensorResponse {
    private Long id;
    private Double humidity;
    private Timestamp dateReceived;
}
