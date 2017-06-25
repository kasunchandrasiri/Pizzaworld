package com.pizzaworld.central.service.serviceImpl;

import com.pizzaworld.central.dao.model.CentralRole;
import com.pizzaworld.central.dao.model.CentralUser;
import com.pizzaworld.central.dao.repository.CentralRoleRepository;
import com.pizzaworld.central.dao.repository.CentralUserRepository;
import com.pizzaworld.central.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private CentralUserRepository centralUserRepository;
    @Autowired
    private CentralRoleRepository centralRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CentralUser findByUsername(String name) {
        return centralUserRepository.findByUsername(name);
    }

    @Override
    public List<CentralRole> findAllRoles() {
        return centralRoleRepository.findAll();
    }

    @Override
    public CentralUser save(CentralUser user) {
        return centralUserRepository.save(user);
    }

    @Override
    public CentralUser findOne(Long userId) {
        return centralUserRepository.findOne(userId);
    }

    @Override
    public boolean isValidCurrentPassword(String password, String encodePassword) {
        return passwordEncoder.matches(password, encodePassword);
    }


}
