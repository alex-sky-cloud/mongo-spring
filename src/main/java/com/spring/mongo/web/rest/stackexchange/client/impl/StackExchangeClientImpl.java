package com.spring.mongo.web.rest.stackexchange.client.impl;

import com.spring.mongo.service.dto.stackexchange.ItemsDto;
import com.spring.mongo.service.dto.stackexchange.SiteDto;
import com.spring.mongo.web.rest.stackexchange.client.StackExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class StackExchangeClientImpl implements StackExchangeClient {


    private RestTemplate restTemplate;


    @Autowired
    public StackExchangeClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<SiteDto> getSitesFromResource() {

        URI resource = transformUrlToURI();

        ItemsDto response = restTemplate.getForObject(resource, ItemsDto.class);

        List<SiteDto> items = response.getItems();

        return items;
    }


    /**
     * Преобразуем строковое представление адреса в объект типа URI
     */
    private URI transformUrlToURI() {

        String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=9999&filter=!FmOlfAlxFUtvbPT*KIaDscnSK*";

        URI uri = null;

        try {
            uri = new URI(url);

        } catch (URISyntaxException e) {

            throw new RuntimeException(e);
        }

        return uri;
    }
}
