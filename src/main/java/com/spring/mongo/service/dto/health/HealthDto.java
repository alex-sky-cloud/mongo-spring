package com.spring.mongo.service.dto.health;

import java.util.Objects;

public class HealthDto {

    String status;

    Integer attempt;

    public HealthDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthDto healthDto = (HealthDto) o;
        return Objects.equals(status, healthDto.status) &&
                Objects.equals(attempt, healthDto.attempt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, attempt);
    }

    @Override
    public String toString() {
        return "HealthDto{" +
                "status='" + status + '\'' +
                ", attempt=" + attempt +
                '}';
    }
}
