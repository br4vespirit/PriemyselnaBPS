package com.example.pbs.repository;

import com.example.pbs.model.dao.MotionSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotionSensorRepository extends JpaRepository<MotionSensor, Long> {

    @Query(nativeQuery = true, value = "SELECT * from motion_sensor order by id desc limit 20")
    List<MotionSensor> findTwentyHighest();
}