package com.spring.mongo.web.rest.stackexchange.client;


import com.spring.mongo.service.dto.stackexchange.SiteDto;

import java.util.List;

public interface StackExchangeClient {

    /**
     * получение списка сайтов. Для этого вызывается клиент, который запрашивает данную
     * информацию из сети интернет
     * @return
     */
    List<SiteDto> getSitesFromResource();

}
