package com.pizzaworld.store.service.serviceImpl;

import com.pizzaworld.common.rest.response.SimpleResponse;
import com.pizzaworld.common.rest.response.StoreRegisterResponse;
import com.pizzaworld.store.dao.model.Store;
import com.pizzaworld.store.service.StoreManagementService;
import com.pizzaworld.store.service.StoreRestCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:service.properties")
public class StoreRestCallServiceImpl implements StoreRestCallService {

    @Value("${central.server.location}")
    private String centralServerLocation;
    @Value("${store.register.path}")
    private String storeRegisterPath;
    @Value("${store.api.path}")
    private String storeApiPath;
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private StoreManagementService storeManagementService;

    @Override
    public Store storeRegisterRestCall(String identifier) {
        StoreRegisterResponse storeRegisterResponse = restTemplate.getForObject(centralServerLocation + storeApiPath + storeRegisterPath + identifier, StoreRegisterResponse.class);
        if (storeRegisterResponse != null && storeRegisterResponse.getIdentifier().equals(identifier)) {
            return new Store(storeRegisterResponse.getName(),storeRegisterResponse.getStreetNumber(),storeRegisterResponse.getStreet()
            ,storeRegisterResponse.getCity(),storeRegisterResponse.getPostCode(),storeRegisterResponse.getIdentifier(),storeRegisterResponse.getStatus());
        } else {
            return null;
        }
    }
}
