package com.collindigm.runnerz.run;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    String home() {
        return "Hello, Welcome to Runnerz";
    }

}
