package com.pizzaworld.central.web.web.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest extends AbstractControllerTest {
    private MockMvc mockMvc;

    @Test
    public void loginTest() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/public/login"));
    }

    @Test
    public void logoutTest() throws Exception {
        this.mockMvc.perform(get("/logout"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/public/login"));
    }

    @Test
    public void homeTest() throws Exception {
        this.mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/administrator/home"));
    }
}
