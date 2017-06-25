package com.pizzaworld.central.dao.repository;

import com.pizzaworld.central.dao.model.CentralUser;
import com.pizzaworld.common.dao.test.AbstractRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CentralUserRepositoryTest extends AbstractRepositoryTest<CentralUser, CentralUserRepository> {
    @Autowired
    CentralUserRepository centralUserRepository;

    @Override
    public CentralUser getRandomEntity() {
        return new CentralUser(getRandomString(),getRandomString(),Boolean.TRUE,Collections.EMPTY_LIST);
    }

    @Override
    public CentralUser getModifiedEntity(CentralUser entity) {
        entity.setEnabled(Boolean.FALSE);
        entity.setPassword(getRandomString());
        return entity;
    }

    @Override
    public CentralUserRepository getRepository() {
        return centralUserRepository;
    }

    @Test
    public  void findByUsernameTest() throws Exception{
        CentralUser centralUser =centralUserRepository.save( getRandomEntity());
        assertEquals(centralUser,centralUserRepository.findByUsername(centralUser.getUsername()));
    }
}
