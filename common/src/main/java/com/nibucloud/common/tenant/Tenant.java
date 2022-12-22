package com.nibucloud.common.tenant;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Tenant")
public class Tenant implements Serializable {

    @Id
    private String tenantId;

    private String displayName;

    private String dbName;

    private String host;

    private int port;

    private String username;

    private String password;

    private boolean enabled;

    List<String> allowedUsers;

    public Tenant() {
    }


    public Tenant( String displayName, String dbName, String host, int port, String username, String password,
            boolean enabled, List<String> allowedUsers ) {
        this.displayName = displayName;
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.allowedUsers = allowedUsers;
    }


    public Tenant( String tenantId, String displayName, String dbName, String host, int port, String username,
            String password, boolean enabled, List<String> allowedUsers ) {
        this.tenantId = tenantId;
        this.displayName = displayName;
        this.dbName = dbName;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.allowedUsers = allowedUsers;
    }


    public String getTenantId() {
        return tenantId;
    }


    public void setTenantId( String tenantId ) {
        this.tenantId = tenantId;
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


    public List<String> getAllowedUsers() {
        return allowedUsers;
    }


    public void setAllowedUsers( List<String> allowedUsers ) {
        this.allowedUsers = allowedUsers;
    }
}
