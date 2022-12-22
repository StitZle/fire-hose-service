package com.nibucloud.common.tenant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepository extends CrudRepository<Tenant, String > {

}
