package com.pizzaworld.central.dao.repository;

import com.pizzaworld.central.dao.model.CentralRole;
import com.pizzaworld.common.dao.test.AbstractRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

public class CentralRoleRepositoryTest extends AbstractRepositoryTest<CentralRole, CentralRoleRepository> {

    @Autowired
    CentralRoleRepository centralRoleRepository;

    @Override
    public CentralRole getRandomEntity() {
        return new CentralRole(getRandomString());
    }

    @Override
    public CentralRole getModifiedEntity(CentralRole entity) {
        entity.setRole(getRandomString());
        return entity;
    }

    @Override
    public CentralRoleRepository getRepository() {
        return centralRoleRepository;
    }
}
