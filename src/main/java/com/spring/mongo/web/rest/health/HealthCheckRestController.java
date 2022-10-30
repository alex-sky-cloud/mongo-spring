package com.spring.mongo.web.rest.health;

import com.spring.mongo.service.dto.health.HealthDto;
import com.spring.mongo.service.read.health.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckRestController {

    private HealthCheckService service;

    @Autowired
    public HealthCheckRestController(HealthCheckService service) {
        this.service = service;
    }

    @GetMapping("api/check")
    public HealthDto checkStatusService(){

        service.resetAttempt();

        return buildResponse(service.getHealth());

    }

    private HealthDto buildResponse(ResponseEntity<String> health){

        int attemptCount = service.getAttemptCount();

        HealthDto healthDto = new HealthDto();
        String status = "";

        int statusCodeValue = health.getStatusCodeValue();


        if(statusCodeValue == 200) status = "OK";
        if(statusCodeValue == 500) {
            status = "INTERNAL_SERVER_ERROR";
            System.out.println("status :" + status);
        }

        healthDto.setAttempt(attemptCount);
        healthDto.setStatus(status);

        return healthDto;
    }
}
