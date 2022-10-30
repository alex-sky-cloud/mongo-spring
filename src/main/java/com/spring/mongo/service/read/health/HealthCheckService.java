package com.spring.mongo.service.read.health;

import org.springframework.http.ResponseEntity;

public interface HealthCheckService {

    ResponseEntity<String> getHealth();

    /**
     * очистка счетчика попыток запрос состояния сервера
     */
    void resetAttempt();

     int getAttemptCount();
}
