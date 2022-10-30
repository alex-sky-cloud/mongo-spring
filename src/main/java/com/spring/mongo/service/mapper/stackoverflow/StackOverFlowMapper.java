package com.spring.mongo.service.mapper.stackoverflow;

import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import com.spring.mongo.service.dto.stackoverflow.StackOverFlowDto;
import com.spring.mongo.service.mapper.CommonMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StackOverFlowMapper extends CommonMapper<StackOverFlowDto, StackOverFlowWebsite> {
}
