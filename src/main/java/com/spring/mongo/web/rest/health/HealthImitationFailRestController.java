package com.spring.mongo.web.rest.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HealthImitationFailRestController {

    @GetMapping("api/health")
    public ResponseEntity <String> getStatus(){

        ResponseEntity<String> stringResponseEntity = generateMistake();

        return stringResponseEntity;
    }

    private ResponseEntity<String> generateMistake(){

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(2);
           if (randomInt == 1)
            return new ResponseEntity<>("INTERNAL_SERVER_ERROR",
                    HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
