package com.nibucloud.frontendservice.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.nibucloud.common.tenant.TenantAliasNotFoundException;


@Configuration
public class MultiTenantMongoDBFactory extends SimpleMongoClientDatabaseFactory {

    @Autowired
    private MongoDataSources mongoDataSources;


    public MultiTenantMongoDBFactory( @Qualifier("getMongoClient") MongoClient mongoClient, String databaseName ) {
        super( mongoClient, databaseName );
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
