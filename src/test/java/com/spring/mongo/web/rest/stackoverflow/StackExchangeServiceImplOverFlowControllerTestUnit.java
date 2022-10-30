package com.spring.mongo.web.rest.stackoverflow;

import com.spring.mongo.SpringMongoApplication;
import com.spring.mongo.service.read.stackoverflow.StackOverFlowService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringMongoApplication.class})
@WebMvcTest(StackOverFlowRestController.class)
class StackExchangeServiceImplOverFlowControllerTestUnit {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StackOverFlowService service;

    @Test
    void getListOfProviders() throws Exception {

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/api/stackoverflow")
                        .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(print());

    }
}
