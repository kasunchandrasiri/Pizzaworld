package com.pizzaworld.common.rest.response;

import com.pizzaworld.common.dao.model.City;
import com.pizzaworld.common.dao.model.PostCode;
import com.pizzaworld.common.dao.model.StoreStatus;
import com.pizzaworld.common.dao.model.Street;

import java.io.Serializable;

public class StoreRegisterResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String streetNumber;
    private Street street;
    private City city;
    private PostCode postCode;
    private String identifier;
    private StoreStatus status;

    public StoreRegisterResponse() {
    }

    public StoreRegisterResponse(String name, String streetNumber, Street street, City city, PostCode postCode, String identifier, StoreStatus status) {
        this.name = name;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.identifier = identifier;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public PostCode getPostCode() {
        return postCode;
    }

    public void setPostCode(PostCode postCode) {
        this.postCode = postCode;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public StoreStatus getStatus() {
        return status;
    }

    public void setStatus(StoreStatus status) {
        this.status = status;
    }
}
