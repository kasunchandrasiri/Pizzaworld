package com.pizzaworld.common.dao.model;

public enum StoreStatus {
    READY("Ready"),ACTIVE("Active"), INACTIVE("Inactive");

    private String value;

    StoreStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
