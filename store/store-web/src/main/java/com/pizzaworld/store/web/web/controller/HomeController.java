package com.pizzaworld.store.web.web.controller;

import com.pizzaworld.common.rest.request.StoreRegisterRequest;
import com.pizzaworld.common.rest.response.SimpleResponse;
import com.pizzaworld.common.rest.response.StoreRegisterResponse;
import com.pizzaworld.store.service.StoreManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


@Controller
public class HomeController {
    @Autowired
    private StoreManagementService storeManagementService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "views/public/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "views/public/login";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        if (storeManagementService.isRegisteredStore()) {
            return "views/administrator/home";
        } else {
            return "redirect:administrator/store/getRegister";
        }
    }


}
