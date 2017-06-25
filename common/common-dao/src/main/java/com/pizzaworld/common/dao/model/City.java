package com.pizzaworld.common.dao.model;

public enum City {
    AUCKLAND("Auckland"), WELLINGTON("Wellington");

    private String value;

    City(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
