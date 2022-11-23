package com.example.pbs.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class WaterSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_water_present")
    private boolean isWaterPresent;

    @Column(name = "date_received")
    private Timestamp dateReceived;
}