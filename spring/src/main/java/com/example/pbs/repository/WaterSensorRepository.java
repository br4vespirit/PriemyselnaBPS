package com.example.pbs.repository;

import com.example.pbs.model.dao.WaterSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterSensorRepository extends JpaRepository<WaterSensor, Long> {

    @Query(nativeQuery = true, value = "SELECT * from water_sensor order by id desc limit 24")
    List<WaterSensor> findTwentyHighest();
}