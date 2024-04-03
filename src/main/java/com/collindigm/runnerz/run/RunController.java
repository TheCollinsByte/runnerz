package com.collindigm.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/runs")
public class RunController {
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    Run findById(@PathVariable Integer id) {

        Optional<Run> run = runRepository.findById(id);

        if(run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    void create(@RequestBody Run run) {
        runRepository.create(run);
    }

    // put

    // delete
}
