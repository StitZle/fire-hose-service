package com.niclas.adminservice.Tenant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepository extends CrudRepository<Tenant, String > {

}
