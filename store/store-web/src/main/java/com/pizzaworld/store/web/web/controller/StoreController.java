package com.pizzaworld.store.web.web.controller;

import com.pizzaworld.store.dao.model.Store;
import com.pizzaworld.store.service.StoreManagementService;
import com.pizzaworld.store.service.StoreRestCallService;
import com.pizzaworld.store.web.web.form.StoreRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/administrator/store")
public class StoreController {
    @Autowired
    private StoreManagementService storeManagementService;
    @Autowired
    private StoreRestCallService storeRestCallService;

    @RequestMapping(value = "/getRegister", method = RequestMethod.GET)
    public ModelAndView registerStore() {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/storeRegister");
        modelAndView.addObject("storeRegisterForm", new StoreRegisterForm());
        return modelAndView;
    }

    @RequestMapping(value = "/registerStore", method = RequestMethod.POST)
    public ModelAndView registerStore(@Valid StoreRegisterForm storeRegisterForm, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/storeRegister");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("storeRegisterForm", storeRegisterForm);
        } else {
            Store store = storeRestCallService.storeRegisterRestCall(storeRegisterForm.getIdentifier());
            if (store != null) {
                store = storeManagementService.save(store);
                modelAndView = new ModelAndView("redirect:/home");
            }else{
                modelAndView.addObject("errorMsg","Invalid identifier");
            }
        }
        return modelAndView;
    }
}
