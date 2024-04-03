package com.collindigm.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Repository
public class RunRepository {

    List<Run> runs = new ArrayList<>();

    /**
     * Package Protected
     */
    List<Run> findAll() {
        return runs;
    }


    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Tuesday Afternoon Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 2, Location.INDOOR));
        runs.add(new Run(3, "Wednesday Evening Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 7, Location.OUTDOOR));
    }
}
