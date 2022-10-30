package com.spring.mongo.dao.repository;

import com.spring.mongo.dao.model.sites.SiteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StackExchangeRepository extends MongoRepository<SiteEntity, String> {
}
