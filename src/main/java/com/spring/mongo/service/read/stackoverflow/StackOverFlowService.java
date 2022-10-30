package com.spring.mongo.service.read.stackoverflow;

import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;

import java.net.URISyntaxException;
import java.util.List;

public interface StackOverFlowService {

    /**
     * получить список веб-сайтов
     * @return список веб-сайтов
     * @throws URISyntaxException бросается, в случае запроса по неправильному адресу
     */
     List<StackOverFlowDto> getAllSites() throws URISyntaxException;

    /**
     *  получить список веб-сайтов по указанному заголовку
     * @param title имя заголовка
     * @return список веб-сайтов
     * @throws URISyntaxException
     */
    List<StackOverFlowDto> getAllSitesByTitle(String title) throws URISyntaxException;
}
