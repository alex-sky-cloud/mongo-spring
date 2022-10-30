package com.spring.mongo.service.dto.recaptcha;

import java.util.Objects;

public class RegisterDto {

    private String email;

    private String password;

    private String recaptchaResponse;

    public RegisterDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecaptchaResponse() {
        return recaptchaResponse;
    }

    public void setRecaptchaResponse(String recaptchaResponse) {
        this.recaptchaResponse = recaptchaResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterDto that = (RegisterDto) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(recaptchaResponse, that.recaptchaResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, recaptchaResponse);
    }

    @Override
    public String toString() {
        return "RegisterDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", recaptchaResponse='" + recaptchaResponse + '\'' +
                '}';
    }
}
