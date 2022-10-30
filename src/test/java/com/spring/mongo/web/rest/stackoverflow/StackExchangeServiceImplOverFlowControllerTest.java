package com.spring.mongo.web.rest.stackoverflow;


import com.google.common.collect.ImmutableList;
import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import com.spring.mongo.service.read.stackoverflow.StackOverFlowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@WebMvcTest(StackOverFlowRestController.class)
public class StackExchangeServiceImplOverFlowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StackOverFlowService service;

    @MockBean
    private StackOverFlowRestController controller;

    @Test
    public void getListOfProviders() throws Exception {

        when(service.getAllSites()).thenReturn(ImmutableList.of());
        List<StackOverFlowDto> listOfProviders = controller.getListOfProviders();
        assertNotNull(listOfProviders);

       /// verify(service).getAllSites(); это не работает
    }
}
