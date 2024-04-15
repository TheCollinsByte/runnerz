package com.collindigm.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
            throw new RunNotFoundException();
        }

        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    void create(@Valid @RequestBody Run run) {
        runRepository.save(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.save(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Integer id) {
        runRepository.delete(runRepository.findById(id).get());
    }

    @RequestMapping(path = "/location/{location}", method = RequestMethod.GET)
    List<Run> findByLocation(@PathVariable String location) {
        return runRepository.findAllByLocation(location.toUpperCase());
    }
}
