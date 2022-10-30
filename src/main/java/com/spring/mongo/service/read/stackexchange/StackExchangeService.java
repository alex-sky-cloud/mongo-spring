package com.spring.mongo.service.read.stackexchange;

import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;

import java.util.List;

public interface StackExchangeService {

    /**
     * получаем для обработки список сайтов
     * @return
     */
    List<StackOverFlowDto> getSites();

}
