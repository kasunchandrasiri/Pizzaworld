package com.pizzaworld.central.web.web.controller;

import com.pizzaworld.central.dao.model.CentralRole;
import com.pizzaworld.central.dao.model.CentralUser;
import com.pizzaworld.central.service.UserManagementService;
import com.pizzaworld.central.web.web.form.UpdatePasswordForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/administrator/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserManagementService userManagementService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView showProfile(Principal principal) {
        ModelAndView view = new ModelAndView("views/administrator/user/user");
        CentralUser centralUser = userManagementService.findByUsername(principal.getName());
        view.addObject("centralUser", centralUser);
        view.addObject("principal", principal);
        view.addObject("updatePasswordForm", new UpdatePasswordForm(centralUser.getId()));
        return view;
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updateUserPassword(@Valid UpdatePasswordForm updatePasswordForm, BindingResult bindingResult, Model model, Principal principal) {
        CentralUser centralUser = userManagementService.findOne(updatePasswordForm.getUserId());
        if (principal.getName().equals(centralUser.getUsername())) {
            model.addAttribute("centralUser", centralUser);
            model.addAttribute("principal", principal);
            model.addAttribute("updatePasswordForm", updatePasswordForm);
            if (bindingResult.hasErrors()) {
                LOGGER.error("Update Password Form contains errors: {}", bindingResult.getAllErrors());
            } else {
                if (userManagementService.isValidCurrentPassword(updatePasswordForm.getCurrentPassword(), centralUser.getPassword())) {
                    if (updatePasswordForm.getNewPassword().equals(updatePasswordForm.getNewPasswordConfirmed())) {
                        centralUser.setPassword(passwordEncoder.encode(updatePasswordForm.getNewPassword()));
                        userManagementService.save(centralUser);
                        model.addAttribute("successMsg", "User password updated successfully");
                    } else {
                        model.addAttribute("errorMsg", "New passwords don't match");
                    }
                } else {
                    model.addAttribute("errorMsg", "Current password is incorrect");
                }
            }
        } else {
            model.addAttribute("errorMsg", "User can only update own password");
        }
        return "views/administrator/user/user";
    }
    @ModelAttribute("allCentralRoles")
    private List<CentralRole> getCentralRoles() {
        return userManagementService.findAllRoles();
    }

}
