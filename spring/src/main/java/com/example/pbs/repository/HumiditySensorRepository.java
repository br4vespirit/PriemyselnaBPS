package com.example.pbs.repository;

import com.example.pbs.model.dao.HumiditySensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumiditySensorRepository extends JpaRepository<HumiditySensor, Long> {

    @Query(nativeQuery = true, value = "SELECT * from humidity_sensor order by id desc limit 20")
    List<HumiditySensor> findTwentyHighest();
}
