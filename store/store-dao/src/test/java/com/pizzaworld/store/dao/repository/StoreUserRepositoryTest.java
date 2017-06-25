package com.pizzaworld.store.dao.repository;

import com.pizzaworld.store.dao.model.StoreUser;
import com.pizzaworld.common.dao.test.AbstractRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class StoreUserRepositoryTest extends AbstractRepositoryTest<StoreUser,StoreUserRepository> {
    @Autowired
    StoreUserRepository storeUserRepository;

    @Override
    public StoreUser getRandomEntity() {
        return new StoreUser(getRandomString(),getRandomString(),Boolean.TRUE, Collections.EMPTY_LIST);
    }

    @Override
    public StoreUser getModifiedEntity(StoreUser entity) {
        entity.setPassword(getRandomString());
        entity.setEnabled(Boolean.FALSE);
        return entity;
    }

    @Override
    public StoreUserRepository getRepository() {
        return storeUserRepository;
    }
}
