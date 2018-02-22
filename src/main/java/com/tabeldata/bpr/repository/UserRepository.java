package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.security.UserSecurity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserSecurity, String> {

    List<UserSecurity> findAll();

    UserSecurity findByName(String username);
}
