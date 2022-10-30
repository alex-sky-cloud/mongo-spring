package com.spring.mongo.web.rest.stackoverflow;

import com.google.common.collect.ImmutableList;
import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StackExchangeServiceImplOverFlowControllerTestIt {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StackOverFlowRestController controller;

    @Autowired
    private MongoTemplate mongoTemplate;

/*
    @Before
    public void before(){
        mongoTemplate.dropCollection(StackOverFlowWebsite.class);

        mongoTemplate.save(StackOverFlowWebsite.newBuilder()
                .id("stackoverflow.com")
                .iconImageUrl("http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico")
                .website("http://serverfault.com")
                .title("Stackoverflow website (StackExchange)")
                .description("for professional and enthusiast programmers")
                .build());
        mongoTemplate.save(StackOverFlowWebsite.newBuilder()
                .id("serverfault")
                .iconImageUrl("http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico")
                .website("http://serverfault.com")
                .title("Ask Different (StackExchange)")
                .description("for system and network administrators")
                .build());
    }*/

    @Test
    void getListOfProviders() throws URISyntaxException {

        List<StackOverFlowDto> listOfProviders = controller.getListOfProviders();
        Assert.assertNotNull(listOfProviders);
    }

    @Test
    void getListOfProvidersWithRestTemplate() throws URISyntaxException {

        mongoTemplate.dropCollection(StackOverFlowWebsite.class);

        mongoTemplate.save(StackOverFlowWebsite.newBuilder()
                .id("stackoverflow.com")
                .iconImageUrl("http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico")
                .website("http://serverfault.com")
                .title("Stackoverflow website (StackExchange)")
                .description("for professional and enthusiast programmers")
                .build());
        mongoTemplate.save(StackOverFlowWebsite.newBuilder()
                .id("serverfault")
                .iconImageUrl("http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico")
                .website("http://serverfault.com")
                .title("Ask Different (StackExchange)")
                .description("for system and network administrators")
                .build());

        ParameterizedTypeReference<List<StackOverFlowDto>> parameterizedTypeReference =
                new ParameterizedTypeReference<List<StackOverFlowDto>>() {
                };

        ResponseEntity<List<StackOverFlowDto>> responseEntity =
                restTemplate.exchange("/api/stackoverflow",
                        HttpMethod.GET,
                        null,
                        parameterizedTypeReference);

        List<StackOverFlowDto> actualList = responseEntity.getBody();
        MatcherAssert.assertThat(actualList.size(), is (2));



        List<String> collect = actualList.stream()
                .map(sites -> sites.getId())
                .collect(Collectors.collectingAndThen(toList(), ImmutableList::copyOf));
        System.out.println(collect);

        MatcherAssert.assertThat( collect, Matchers.containsInAnyOrder(
                "stackoverflow.com",
                "serverfault"
        ));

    }

}
