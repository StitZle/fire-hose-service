package com.nibucloud.adminservice.Tenant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nibucloud.common.tenant.Tenant;
import com.nibucloud.common.tenant.TenantAliasNotFoundException;
import com.nibucloud.common.tenant.TenantRecord;
import com.nibucloud.common.tenant.TenantRepository;


@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    public TenantService( TenantRepository tenantRepository ) {
        this.tenantRepository = tenantRepository;
    }

    public Tenant saveTenant( TenantRecord tenantRecord ) {
        Tenant tenant = new Tenant(  tenantRecord.displayName(), tenantRecord.dbName(), tenantRecord.host(), tenantRecord.port(), tenantRecord.username(), tenantRecord.password(),
                tenantRecord.enabled(), tenantRecord.allowedUsers() );
        return tenantRepository.save( tenant );
    }

    public Tenant findTenantById( String tenantId ) throws TenantAliasNotFoundException {
        return tenantRepository.findById( tenantId ).orElseThrow( () -> new TenantAliasNotFoundException( tenantId ) );
    }

    public List<Tenant> findAllTenants() {
        List<Tenant> tenants = new ArrayList<>();
        tenantRepository.findAll().forEach( tenants::add );
        return tenants;
    }

    public Tenant updateTenant(String tenantId, TenantRecord tenantRecord)
            throws TenantAliasNotFoundException {

        Tenant tenant = tenantRepository.findById( tenantId ).orElseThrow(() -> new TenantAliasNotFoundException(
                tenantRecord.displayName() ) );

        tenant.setDisplayName( tenantRecord.displayName() );
        tenant.setDbName( tenantRecord.dbName() );
        tenant.setHost( tenantRecord.host() );
        tenant.setPort( tenantRecord.port() );
        tenant.setUsername( tenantRecord.username() );
        tenant.setPassword( tenantRecord.password() );
        tenant.setEnabled( tenantRecord.enabled() );
        tenant.setAllowedUsers( tenantRecord.allowedUsers());

        return tenantRepository.save( tenant );
    }

    public void deleteTenant(String tenantId){
        tenantRepository.deleteById( tenantId );
    }




}
