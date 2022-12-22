package com.nibucloud.frontendservice.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.nibucloud.common.tenant.Tenant;
import com.nibucloud.common.tenant.TenantAliasNotFoundException;
import com.nibucloud.common.tenant.TenantRepository;



@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;


    public Tenant findTenantById( String tenantId ) throws TenantAliasNotFoundException {
        return tenantRepository.findById( tenantId ).orElseThrow( () -> new TenantAliasNotFoundException( tenantId ) );
    }
}
