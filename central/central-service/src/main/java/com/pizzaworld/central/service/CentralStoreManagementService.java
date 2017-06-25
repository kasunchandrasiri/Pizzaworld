package com.pizzaworld.central.service;

import com.pizzaworld.central.dao.model.CentralStore;
import com.pizzaworld.common.rest.response.StoreRegisterResponse;

import java.util.List;

public interface CentralStoreManagementService {
    List<CentralStore> findAll();

    CentralStore save(CentralStore centralStore);

    CentralStore findOne(Long id);

    StoreRegisterResponse getStoreRegisterResponse(String identifier);

    CentralStore findByIdentifier(String identifier);
}

