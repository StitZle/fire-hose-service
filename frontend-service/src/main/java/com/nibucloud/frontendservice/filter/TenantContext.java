package com.nibucloud.frontendservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TenantContext {

    private static final Logger log = LoggerFactory.getLogger( TenantContext.class );

    private static final ThreadLocal<String> TENANT_CONTEXT = new ThreadLocal<>();

    public static void setTenantId(String tenantId){
        log.info( "Setting tenantId to: {}", tenantId );
        TENANT_CONTEXT.set(tenantId);
    }

    public static String getTenantId(){
        return TENANT_CONTEXT.get();
    }

    public static void clear(){
        TENANT_CONTEXT.remove();
    }
}
