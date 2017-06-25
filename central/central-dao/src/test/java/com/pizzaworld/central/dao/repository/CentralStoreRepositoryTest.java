package com.pizzaworld.central.dao.repository;

import com.pizzaworld.central.dao.model.CentralStore;
import com.pizzaworld.common.dao.model.City;
import com.pizzaworld.common.dao.model.PostCode;
import com.pizzaworld.common.dao.model.StoreStatus;
import com.pizzaworld.common.dao.model.Street;
import com.pizzaworld.common.dao.test.AbstractRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

public class CentralStoreRepositoryTest extends AbstractRepositoryTest<CentralStore,CentralStoreRepository> {
   @Autowired
   CentralStoreRepository centralStoreRepository;

    @Override
    public CentralStore getRandomEntity() {
        return new CentralStore(getRandomString(),getRandomString(), Street.STREET_1, City.WELLINGTON, PostCode.PC_1000,getRandomString(), StoreStatus.ACTIVE);
    }

    @Override
    public CentralStore getModifiedEntity(CentralStore entity) {
        entity.setStatus(StoreStatus.INACTIVE);
        return entity;
    }

    @Override
    public CentralStoreRepository getRepository() {
        return centralStoreRepository;
    }
}
