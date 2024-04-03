package com.collindigm.runnerz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunController {
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @RequestMapping(path = "/api/runs", method = RequestMethod.GET)
    List<Run> home() {
        return runRepository.findAll();
    }

}
