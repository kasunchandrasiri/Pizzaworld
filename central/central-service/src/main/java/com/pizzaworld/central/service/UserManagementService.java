package com.pizzaworld.central.service;

import com.pizzaworld.central.dao.model.CentralRole;
import com.pizzaworld.central.dao.model.CentralUser;

import java.util.List;

public interface UserManagementService {
   CentralUser findByUsername(String name);

    List<CentralRole> findAllRoles();

    CentralUser save(CentralUser user);

    CentralUser findOne(Long userId);

    boolean isValidCurrentPassword(String password, String encodePassword);
}
