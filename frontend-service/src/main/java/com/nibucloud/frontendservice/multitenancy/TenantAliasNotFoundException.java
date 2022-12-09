package com.nibucloud.frontendservice.multitenancy;

public class TenantAliasNotFoundException extends Exception{
    public TenantAliasNotFoundException(String tenantId) {
        super("Tenant with id: " + tenantId + " not found!");
    }
}
