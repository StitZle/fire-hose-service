package com.nibucloud.frontendservice.multitenancy;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.nibucloud.frontendservice.filter.TenantContext;


@Component
public class MongoDataSources {

    private final TenantService tenantService;


    public MongoDataSources( TenantService tenantService ) {
        this.tenantService = tenantService;
    }

    @Bean
    public String databaseName() {
        return "unused";
    }

    @Bean
    public MongoClient getMongoClient(){
        MongoCredential credential = MongoCredential.createCredential("admin", "unused", "admin".toCharArray());
        return MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(new ServerAddress("localhost", 27017))))
                .credential(credential)
                .build());
    }


    public MongoDatabase mongoDatabaseCurrentTenantResolver() throws TenantAliasNotFoundException {

        final String tenantId = TenantContext.getTenantId();
        Tenant tenant = tenantService.findTenantById( tenantId );

        MongoCredential mongoCredential = MongoCredential.createCredential( tenant.getUsername(), tenant.getDbName(),
                tenant.getPassword().toCharArray() );
        MongoClient mongoClient = MongoClients.create( MongoClientSettings.builder()
                .applyToClusterSettings( builder -> builder.hosts(
                        Collections.singletonList( new ServerAddress( tenant.getHost(), tenant.getPort() ) ) ) )
                .credential( mongoCredential )
                .build() );

        return mongoClient.getDatabase( tenant.getDbName() );
    }

}
