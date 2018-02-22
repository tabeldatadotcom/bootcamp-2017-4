package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.security.RoleSecurity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<RoleSecurity, Long> {

    List<RoleSecurity> findAll();
}
