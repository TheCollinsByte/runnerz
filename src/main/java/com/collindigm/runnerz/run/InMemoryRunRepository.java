package com.collindigm.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class InMemoryRunRepository {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryRunRepository.class);

    List<Run> runs = new ArrayList<>();

    /**
     * Package Protected
     */
    List<Run> findAll() {
        return runs;
    }


    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 5, Location.OUTDOOR, null));
        runs.add(new Run(2, "Tuesday Afternoon Run", LocalDateTime.now(), LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 2, Location.INDOOR, null));
        runs.add(new Run(3, "Wednesday Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(40, ChronoUnit.MINUTES), 7, Location.OUTDOOR, null));
    }
}
