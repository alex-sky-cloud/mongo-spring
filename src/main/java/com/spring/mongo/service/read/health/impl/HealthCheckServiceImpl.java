package com.spring.mongo.service.read.health.impl;

import com.spring.mongo.service.read.health.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

   public static final String RECOVER_MESSAGE = "not ok";

   private RestTemplate restTemplate;

    int attempt = 0;

   @Autowired
    public HealthCheckServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public int getAttemptCount() {
        return attempt;
    }

    /**
     * перед каждой попыткой счетчик попытко будет увеличиваться
     * @return
     */
    @Retryable(maxAttempts = 4,
            value = RuntimeException.class,
            backoff =
            @Backoff(delay = 500, multiplier = 2)
    )
    @Override
    public ResponseEntity<String> getHealth() {

       attempt++;

       String urlToHealth = "http://localhost:8099/api/health";

        ResponseEntity<String> response =  restTemplate.getForEntity(urlToHealth, String.class);

        return response;

      }

    @Override
    public void resetAttempt() {
        attempt = 0;
    }


    @Recover
    public ResponseEntity<String> recover() {
        return new ResponseEntity<>(RECOVER_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR); //if max attempts achieved
    }
}
