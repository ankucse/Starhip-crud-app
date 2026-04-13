package com.example.subbu.CRUD_App.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {

    @Autowired
    private MappingMongoConverter mappingMongoConverter;

    @PostConstruct
    public void removeClassField() {
        // Setting the type mapper to null removes the _class field from being saved
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }
}