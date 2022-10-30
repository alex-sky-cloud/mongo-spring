package com.spring.mongo.service.read.stackoverflow.impl;

import com.google.common.collect.ImmutableList;
import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import com.spring.mongo.dao.repository.StackOverFlowWebsiteRepository;
import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import com.spring.mongo.service.mapper.stackoverflow.StackOverFlowMapper;
import com.spring.mongo.service.read.stackoverflow.StackOverFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class StackOverFlowServiceImpl implements StackOverFlowService {

    private StackOverFlowWebsiteRepository repository;

    private StackOverFlowMapper mapper;

    @Autowired
    public StackOverFlowServiceImpl(StackOverFlowWebsiteRepository repository,
                                    StackOverFlowMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<StackOverFlowDto> getAllSitesByTitle(String title) throws URISyntaxException {

            List<StackOverFlowWebsite> stackOverFlowWebsiteByTitleIsLike =
                    repository.findStackOverFlowWebsiteByTitleIsLike(title);

            List<StackOverFlowDto> stackOverFlowDtoList =
                    (List<StackOverFlowDto>) mapper.toListDto(stackOverFlowWebsiteByTitleIsLike);


            return ImmutableList.copyOf(stackOverFlowDtoList);
    }



    @Override
    public List<StackOverFlowDto> getAllSites() throws URISyntaxException {

        List<StackOverFlowWebsite> allEntries = repository.findAll();

        Iterable<StackOverFlowDto> stackOverFlowDtoList = mapper.toListDto(allEntries);

        return ImmutableList.copyOf(stackOverFlowDtoList);
    }

    /*
    @PostConstruct
    public void init(){
        Iterable<StackOverFlowWebsite> items = StackOverFlowList.getItems();
        repository.saveAll(items);
    }
*/
}
