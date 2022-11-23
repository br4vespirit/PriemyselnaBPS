package com.example.pbs.model.dao;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SoundSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    @Column(name = "sound_date")
    private Timestamp dateReceived;
}