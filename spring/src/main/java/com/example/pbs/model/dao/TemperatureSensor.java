package com.example.pbs.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureSensor {

    @Id
    @GeneratedValue
    private Long id;

    private Double temperature;

    @Column(name = "date_received")
    private Timestamp dateReceived;
}