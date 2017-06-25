package com.pizzaworld.common.dao.model;

public enum Street {
    STREET_1("Street 1"), STREET_2("Street_2");

    private String value;

    Street(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
