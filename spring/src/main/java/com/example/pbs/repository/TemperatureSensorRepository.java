package com.example.pbs.repository;

import com.example.pbs.model.dao.TemperatureSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureSensorRepository extends JpaRepository<TemperatureSensor, Long> {

    @Query(nativeQuery = true, value = "SELECT * from temperature_sensor order by id desc limit 20")
    List<TemperatureSensor> findTwentyHighest();
}