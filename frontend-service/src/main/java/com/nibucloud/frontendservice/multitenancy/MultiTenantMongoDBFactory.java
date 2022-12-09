package com.nibucloud.frontendservice.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;


@Configuration
public class MultiTenantMongoDBFactory extends SimpleMongoClientDatabaseFactory {

    @Autowired
    private MongoDataSources mongoDataSources;


    public MultiTenantMongoDBFactory( @Qualifier("getMongoClient") MongoClient mongoClient, String databseName ) {
        super( mongoClient, databseName );
    }

    @Override
    protected MongoDatabase doGetMongoDatabase(String dbName) {
        try {
            return mongoDataSources.mongoDatabaseCurrentTenantResolver();
        }
        catch( TenantAliasNotFoundException e ) {
            throw new RuntimeException( e );
        }
    }

}
