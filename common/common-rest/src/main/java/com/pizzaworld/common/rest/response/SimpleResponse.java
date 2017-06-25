package com.pizzaworld.common.rest.response;

import java.io.Serializable;

public class SimpleResponse   implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public SimpleResponse() {
    }

    public SimpleResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
