package com.collindigm.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository
public class RunRepository {

    List<Run> runs = new ArrayList<>();

    /**
     * Package Protected
     */
    List<Run> findAll() {
        return runs;
    }


    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(1, "Tuesday Afternoon Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 2, Location.INDOOR));
        runs.add(new Run(2, "Wednesday Evening Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 7, Location.OUTDOOR));
    }
}
