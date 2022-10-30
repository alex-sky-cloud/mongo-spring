package com.spring.mongo.dao.repository;


import com.spring.mongo.dao.model.stackoverflow.StackOverFlowWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StackOverFlowWebsiteRepositoryWithMongoTemplate {

    private MongoTemplate mongoTemplate;

    @Autowired
    public StackOverFlowWebsiteRepositoryWithMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<StackOverFlowWebsite> findAll(){

        return mongoTemplate.findAll(StackOverFlowWebsite.class);
    }

}

