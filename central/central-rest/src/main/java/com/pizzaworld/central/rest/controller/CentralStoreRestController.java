package com.pizzaworld.central.rest.controller;

import com.pizzaworld.central.dao.model.CentralStore;
import com.pizzaworld.central.service.CentralStoreManagementService;
import com.pizzaworld.common.dao.model.StoreStatus;
import com.pizzaworld.common.rest.response.StoreRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/store")
public class CentralStoreRestController {
    @Autowired
    private CentralStoreManagementService centralStoreManagementService;

    @RequestMapping(value = "/register/{identifier}", method = RequestMethod.GET)
    public @ResponseBody
    StoreRegisterResponse test(@PathVariable("identifier") String identifier) {
        CentralStore centralStore = centralStoreManagementService.findByIdentifier(identifier);
        if (centralStore != null && centralStore.getStatus().equals(StoreStatus.READY)) {
            centralStore.setStatus(StoreStatus.ACTIVE);
            centralStore = centralStoreManagementService.save(centralStore);
            return new StoreRegisterResponse(centralStore.getName(), centralStore.getStreetNumber(), centralStore.getStreet()
                    , centralStore.getCity(), centralStore.getPostCode(), centralStore.getIdentifier(), centralStore.getStatus());
        } else {
            return null;
        }
    }
}
