package com.pizzaworld.store.web.web.form;

public class StoreRegisterForm {
    private String identifier;

    public StoreRegisterForm() {
    }

    public StoreRegisterForm(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
