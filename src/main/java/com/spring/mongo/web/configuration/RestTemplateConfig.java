package com.spring.mongo.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Нужен для того, чтобы Spring инициализировал объекта
 * типа {@link RestTemplate}. Тогда мы можем будем указывать автоматическое
 * инжектирование данного объекта в нужном месте
 */
@Configuration
public class RestTemplateConfig {


    /**
     * restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()) -
     *нужен, чтобы включить gzip-кодирование для вашего ответа, и таким образом избежать
     * ошибки, во время преобразования Jackson полученного JSON в нужный объект. Содержимое ответа
     * приходит в архиве gzip и к нему применена кодировка UTF-8
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return restTemplate;
    }


}
