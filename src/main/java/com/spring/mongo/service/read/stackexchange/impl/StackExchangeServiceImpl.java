package com.spring.mongo.service.read.stackexchange.impl;

import com.google.common.collect.ImmutableList;
import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import com.spring.mongo.service.dto.stackexchange.SiteDto;
import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import com.spring.mongo.service.mapper.stackoverflow.StackOverFlowMapper;
import com.spring.mongo.service.read.stackexchange.StackExchangeService;
import com.spring.mongo.web.rest.stackexchange.client.StackExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class StackExchangeServiceImpl implements StackExchangeService {

    private StackExchangeClient stackExchangeClient;

    private StackOverFlowMapper mapper;

    @Autowired
    public StackExchangeServiceImpl(StackExchangeClient stackExchangeClient,
                                    StackOverFlowMapper mapper) {
        this.stackExchangeClient = stackExchangeClient;

        this.mapper = mapper;
    }

    @Override
    public List<StackOverFlowDto> getSites() {


        ImmutableList<StackOverFlowWebsite> stackOverFlowWebsites =
                stackExchangeClient.getSitesFromResource().stream()
                .map(this::toStackOverFlowWebsite)
                .filter(this::ignoreMeta)
                .collect(Collectors.collectingAndThen(toList(), ImmutableList::copyOf));

        List<StackOverFlowDto> stackOverFlowDtoList =
                (List<StackOverFlowDto>) mapper.toListDto(stackOverFlowWebsites);

        return stackOverFlowDtoList;
    }

    /**
     * если будет найден id, в значении которого присутсвует слово "meta.", тогда мы
     * инвертируем true в false
     * @param stackoverflowWebsite
     * @return
     */
    private boolean ignoreMeta(@NonNull StackOverFlowWebsite stackoverflowWebsite) {

        String id = stackoverflowWebsite.getId();
        boolean startsWith = id.startsWith("meta.");

        return !startsWith;
    }

    /**
     * преобразование полученного объекта в объект `SiteDto` типа `StackOverFlowWebsite`
     * @param input
     * @return
     */
    private StackOverFlowWebsite toStackOverFlowWebsite(@NonNull SiteDto input) {

        String webSite = input.getSiteUrl();
        String id = webSite.substring("https://".length(), webSite.length() - ".com".length());
        String iconImageUrl = input.getFaviconUrl();
        String title = input.getName();
        String description = input.getAudience();

        return StackOverFlowWebsite.newBuilder()
                .id(id)
                .website(webSite)
                .iconImageUrl(iconImageUrl)
                .title(title)
                .description(description)
                .build();

    }

}
