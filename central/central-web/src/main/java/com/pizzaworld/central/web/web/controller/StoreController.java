package com.pizzaworld.central.web.web.controller;

import com.pizzaworld.central.dao.model.CentralStore;
import com.pizzaworld.central.service.CentralStoreManagementService;
import com.pizzaworld.central.web.web.form.NewStoreForm;
import com.pizzaworld.common.dao.model.City;
import com.pizzaworld.common.dao.model.PostCode;
import com.pizzaworld.common.dao.model.StoreStatus;
import com.pizzaworld.common.dao.model.Street;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping("/administrator/store")
public class StoreController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private CentralStoreManagementService centralStoreManagementService;

    @RequestMapping(value = "/storeList", method = RequestMethod.GET)
    public ModelAndView showStores() {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/storeList");
        modelAndView.addObject("storeList", centralStoreManagementService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/newStore", method = RequestMethod.GET)
    public ModelAndView newStore() {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/newStore");
        modelAndView.addObject("newStoreForm", new NewStoreForm());
        return modelAndView;
    }

    @RequestMapping(value = "/addStore", method = RequestMethod.POST)
    public ModelAndView addStore(@Valid NewStoreForm newStoreForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/newStore");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("newStoreForm", newStoreForm);
            LOGGER.error("New Store Form has error(s) {}", bindingResult.getAllErrors());
        } else {
            modelAndView = new ModelAndView("redirect:/storeList");
            CentralStore centralStore = new CentralStore(newStoreForm.getName(), newStoreForm.getStreetNumber(), newStoreForm.getStreet()
                    , newStoreForm.getCity(), newStoreForm.getPostCode(), UUID.randomUUID().toString(), newStoreForm.getStatus());
            centralStore = centralStoreManagementService.save(centralStore);
            redirectAttributes.addFlashAttribute("successMsg", centralStore.getName() + " store added successfully");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/getStore/{storeId}", method = RequestMethod.GET)
    public ModelAndView getStore(@PathVariable("storeId") Long id) {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/store");
        CentralStore centralStore = centralStoreManagementService.findOne(id);
        modelAndView.addObject("updateStoreForm", new NewStoreForm(centralStore.getId(), centralStore.getName(), centralStore.getStreetNumber(), centralStore.getStreet()
                , centralStore.getCity(), centralStore.getPostCode(), centralStore.getIdentifier(), centralStore.getStatus()));
        return modelAndView;
    }

    @RequestMapping(value = "/updateStore", method = RequestMethod.POST)
    public ModelAndView updateStore(@Valid NewStoreForm updateStoreForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("views/administrator/store/store");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("updateStoreForm", updateStoreForm);
            LOGGER.error("Update Store Form has error(s) {}", bindingResult.getAllErrors());
        } else {
            CentralStore centralStore = centralStoreManagementService.findOne(updateStoreForm.getId());
            if (centralStore != null) {
                centralStore.setName(updateStoreForm.getName());
                centralStore.setCity(updateStoreForm.getCity());
                centralStore.setPostCode(updateStoreForm.getPostCode());
                centralStore.setStatus(updateStoreForm.getStatus());
                centralStore.setStreet(updateStoreForm.getStreet());
                centralStore.setStreetNumber(updateStoreForm.getStreetNumber());
                centralStore = centralStoreManagementService.save(centralStore);
                modelAndView.addObject("successMsg", centralStore.getName() + " store updated successfully");
                modelAndView.addObject("updateStoreForm", new NewStoreForm(centralStore.getId(), centralStore.getName(), centralStore.getStreetNumber(), centralStore.getStreet()
                        , centralStore.getCity(), centralStore.getPostCode(), centralStore.getIdentifier(), centralStore.getStatus()));
            } else {
                modelAndView = new ModelAndView("redirect:/storeList");
                redirectAttributes.addFlashAttribute("errorMsg", updateStoreForm.getName() + " store cannot be found.");
            }
        }
        return modelAndView;
    }

    @ModelAttribute("streetList")
    private List<Street> getStreetList() {
        return Arrays.asList(Street.values());
    }

    @ModelAttribute("cityList")
    private List<City> getCityList() {
        return Arrays.asList(City.values());
    }

    @ModelAttribute("postCodeList")
    private List<PostCode> getPostCodeList() {
        return Arrays.asList(PostCode.values());
    }

    @ModelAttribute("storeStatusList")
    private List<StoreStatus> getStoreStatusList() {
        return Arrays.asList(StoreStatus.values());
    }


}
