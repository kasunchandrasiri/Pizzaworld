package com.pizzaworld.store.service.serviceImpl;

import com.pizzaworld.store.dao.model.Store;
import com.pizzaworld.store.dao.repository.StoreRepository;
import com.pizzaworld.store.service.StoreManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreManagementServiceImpl implements StoreManagementService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public boolean isRegisteredStore() {
        List<Store> storeList = storeRepository.findAll();
        return (storeList != null && storeList.size() == 1);
    }

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }
}
