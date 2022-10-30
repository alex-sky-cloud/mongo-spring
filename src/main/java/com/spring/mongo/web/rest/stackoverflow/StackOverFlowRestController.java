package com.spring.mongo.web.rest.stackoverflow;

import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import com.spring.mongo.service.read.stackoverflow.StackOverFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class StackOverFlowRestController {


    private StackOverFlowService service;

    @Autowired
    public StackOverFlowRestController(StackOverFlowService service) {
        this.service = service;
    }

    @GetMapping("api/stackoverflow")
    public List<StackOverFlowDto> getListOfProviders() throws URISyntaxException {

        List<StackOverFlowDto> allSites = service.getAllSites();

        return allSites;
    }
}
