package com.pizzaworld.common.dao.model;

public enum PostCode {
    PC_1000(1000), PC_2000(2000);

    private int value;

    PostCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
