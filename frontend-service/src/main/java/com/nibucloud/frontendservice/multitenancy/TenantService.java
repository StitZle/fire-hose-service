package com.nibucloud.frontendservice.multitenancy;

import org.springframework.stereotype.Service;


@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    public TenantService( TenantRepository tenantRepository ) {
        this.tenantRepository = tenantRepository;
    }

    public Tenant findTenantById( String tenantId ) throws TenantAliasNotFoundException {
        return tenantRepository.findById( tenantId ).orElseThrow( () -> new TenantAliasNotFoundException( tenantId ) );
    }
}
