package com.nibucloud.frontendservice.multitenancy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepository extends CrudRepository<Tenant, String > {

}
