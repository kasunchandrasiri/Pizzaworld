package com.pizzaworld.central.service.serviceImpl;

import com.pizzaworld.central.dao.model.CentralStore;
import com.pizzaworld.central.dao.repository.CentralStoreRepository;
import com.pizzaworld.central.service.CentralStoreManagementService;
import com.pizzaworld.common.rest.response.StoreRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentralStoreManagementServiceImpl implements CentralStoreManagementService {
    @Autowired
    private CentralStoreRepository centralStoreRepository;


    @Override
    public List<CentralStore> findAll() {
        return centralStoreRepository.findAll();
    }

    @Override
    public CentralStore save(CentralStore centralStore) {
        return centralStoreRepository.save(centralStore);
    }

    @Override
    public CentralStore findOne(Long id) {
        return centralStoreRepository.findOne(id);
    }

    @Override
    public StoreRegisterResponse getStoreRegisterResponse(String identifier) {
        CentralStore centralStore = centralStoreRepository.findByIdentifier(identifier);
        StoreRegisterResponse storeRegisterResponse = null;
        if (centralStore != null) {
            storeRegisterResponse = new StoreRegisterResponse(centralStore.getName(), centralStore.getStreetNumber(), centralStore.getStreet()
                    , centralStore.getCity(), centralStore.getPostCode(), centralStore.getIdentifier(), centralStore.getStatus());
        }
        return storeRegisterResponse;
    }

    @Override
    public CentralStore findByIdentifier(String identifier) {
        return centralStoreRepository.findByIdentifier(identifier);
    }
}
