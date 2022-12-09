package com.niclas.adminservice.Tenant;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Tenant")
public class Tenant implements Serializable {

    @Id
    private String id;

    private String displayName;

    private String dbName;

    private String host;

    private int port;

    private String username;

    private String password;

    private boolean enabled;

    public Tenant() {
    }

    public Tenant( String displayName, String dbName, String host, int port, String username, String password,
            boolean enabled ) {
        this.displayName = displayName;
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }


    public Tenant( String id, String displayName, String dbName, String host, int port, String username, String password,
            boolean enabled ) {
        this.id = id;
        this.displayName = displayName;
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }


    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName( String displayName ) {
        this.displayName = displayName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName( String dbName ) {
        this.dbName = dbName;
    }

    public String getHost() {
        return host;
    }

    public void setHost( String host ) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort( int port ) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        if( password == null ){
            return "";
        }
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }
}
