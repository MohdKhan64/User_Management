package com.tek.sre.ssp.controller;

import com.tek.sre.ssp.entity.Application;
import com.tek.sre.ssp.service.ApplicationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Application")
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/application")
    public Application createApplication(@RequestBody Application application) {
        return this.applicationService.createApplication(application);
    }

}
