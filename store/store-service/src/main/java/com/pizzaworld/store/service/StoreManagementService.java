package com.pizzaworld.store.service;

import com.pizzaworld.store.dao.model.Store;

public interface StoreManagementService {
    boolean isRegisteredStore();

    Store save(Store store);
}
