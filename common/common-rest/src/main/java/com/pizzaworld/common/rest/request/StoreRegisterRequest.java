package com.pizzaworld.common.rest.request;

import java.io.Serializable;

public class StoreRegisterRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String identifier;

    public StoreRegisterRequest() {
    }

    public StoreRegisterRequest(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
