package com.nibucloud.adminservice.Tenant;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibucloud.common.tenant.Tenant;
import com.nibucloud.common.tenant.TenantAliasNotFoundException;
import com.nibucloud.common.tenant.TenantRecord;


@RestController()
@RequestMapping( "/v1/tenants" )
public class TenantController {

    private final TenantService tenantService;


    public TenantController( TenantService tenantService ) {
        this.tenantService = tenantService;
    }


    @PostMapping()
    public ResponseEntity<Tenant> saveTenant( @RequestBody TenantRecord tenantRecord ) {
        Tenant tenant = tenantService.saveTenant( tenantRecord );
        return new ResponseEntity<>( tenant, HttpStatus.OK );
    }


    @GetMapping( "/{tenantId}" )
    public ResponseEntity<Tenant> getTenantById( @PathVariable( value = "tenantId" ) String tenantId )
            throws TenantAliasNotFoundException {
        Tenant tenant = tenantService.findTenantById( tenantId );
        return new ResponseEntity<>( tenant, HttpStatus.OK );
    }


    @GetMapping()
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantService.findAllTenants();
        return new ResponseEntity<>( tenants, HttpStatus.OK );
    }


    @PutMapping( "/{tenantId}" )
    public ResponseEntity<Tenant> updateTenant( @PathVariable( value = "tenantId" ) String tenantId,
            @RequestBody TenantRecord tenantRecord ) throws TenantAliasNotFoundException {
        Tenant tenant = tenantService.updateTenant( tenantId, tenantRecord );
        return new ResponseEntity<>( tenant, HttpStatus.OK );
    }


    @DeleteMapping( "/{tenantId}" )
    public ResponseEntity<Object> deleteTenant( @PathVariable( value = "tenantId" ) String tenantId ) {
        tenantService.deleteTenant( tenantId );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
