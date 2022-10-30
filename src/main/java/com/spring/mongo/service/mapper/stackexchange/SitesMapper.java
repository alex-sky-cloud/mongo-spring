package com.spring.mongo.service.mapper.stackexchange;

import com.spring.mongo.dao.model.sites.SiteEntity;
import com.spring.mongo.service.dto.stackexchange.SiteDto;
import com.spring.mongo.service.mapper.CommonMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SitesMapper extends CommonMapper<SiteDto, SiteEntity> {
}
