package com.example.pbs.repository;

import com.example.pbs.model.dao.SoundSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoundSensorRepository extends JpaRepository<SoundSensor, Long> {

    @Query(nativeQuery = true, value = "SELECT * from sound_sensor order by id desc limit 20")
    List<SoundSensor> findTwentyHighest();
}