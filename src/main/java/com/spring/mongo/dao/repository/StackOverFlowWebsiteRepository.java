package com.spring.mongo.dao.repository;

import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StackOverFlowWebsiteRepository extends MongoRepository<StackOverFlowWebsite, String> {

  List<StackOverFlowWebsite> findStackOverFlowWebsiteByTitleIsLike (String title);
}
