package com.nibucloud.frontendservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import com.nibucloud.frontendservice.multitenancy.TenantAliasNotFoundException;


@Component
public class TenantInterceptor implements WebRequestInterceptor {

   private static final Logger log = LoggerFactory.getLogger( TenantInterceptor.class );

    private static final String TENANT_HEADER = "X-Tenant";

    @Override
    public void preHandle( WebRequest request) throws TenantAliasNotFoundException {
        String tenantId = request.getHeader( TENANT_HEADER );

        if( tenantId == null || tenantId.isEmpty() ){
            log.error( "Could not get tenantId from request!" );
            throw new TenantAliasNotFoundException( "Tenant header in request not found!" );
        }

        TenantContext.setTenantId( tenantId );
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) {
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) {
    }
}
