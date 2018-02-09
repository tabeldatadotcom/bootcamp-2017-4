package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.RoleSecurity;
import com.tabeldata.bpr.entity.master.UserSecurity;
import com.tabeldata.bpr.repository.RoleRepository;
import com.tabeldata.bpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleSecurity> listRole() {
        return this.roleRepository.findAll();
    }

    public List<UserSecurity> findUser() {
        return this.userRepository.findAll();
    }

    public UserSecurity findByUsername(String username) {
        return this.userRepository.findByName(username);
    }

}