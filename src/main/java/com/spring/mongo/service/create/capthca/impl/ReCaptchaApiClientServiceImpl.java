package com.spring.mongo.service.create.capthca.impl;

import com.spring.mongo.service.create.capthca.ReCaptchaApiClientService;
import com.spring.mongo.service.dto.recaptcha.ReCaptchaResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ReCaptchaApiClientServiceImpl implements ReCaptchaApiClientService {

    @Value("${apiUrl}")
    private String reCaptchaApiUrl;

    @Value("${reCaptcha.secretKey}")
    private String secretKey;

    private final RestTemplate restTemplate;

    @Autowired
    public ReCaptchaApiClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ReCaptchaResponseDto verify(String recaptchaResponse) {

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("secret", secretKey);
        form.add("response", recaptchaResponse);

        System.out.println("reCaptchaApiUrl : " + reCaptchaApiUrl);

        return restTemplate.postForObject(reCaptchaApiUrl, form, ReCaptchaResponseDto.class);
    }
}
