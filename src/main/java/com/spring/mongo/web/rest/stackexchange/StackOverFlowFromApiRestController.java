package com.spring.mongo.web.rest.stackexchange;

import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import com.spring.mongo.service.read.stackexchange.StackExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

/**
 * данный rest-controller производит запрос по http, обращаясь по
 * указанному адресу на сайт https://api.stackexchange.com/docs/sites...
 */
@RestController
public class StackOverFlowFromApiRestController {

    private StackExchangeService stackExchangeService;

    @Autowired
    public StackOverFlowFromApiRestController(StackExchangeService stackExchangeService) {

        this.stackExchangeService = stackExchangeService;
    }


    @GetMapping("api/stackexchange")
    public List<StackOverFlowDto> getListOfProviders() throws URISyntaxException {

        List<StackOverFlowDto> allSites = stackExchangeService.getSites();

        return allSites;
    }

}
