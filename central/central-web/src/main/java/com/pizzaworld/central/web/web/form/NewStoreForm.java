package com.pizzaworld.central.web.web.form;

import com.pizzaworld.common.dao.model.*;

public class NewStoreForm {

    private Long id;
    private String name;
    private String streetNumber;
    private Street street;
    private City city;
    private PostCode postCode;
    private String identifier;
    private StoreStatus status;


    public NewStoreForm() {
    }

    public NewStoreForm(Long id, String name, String streetNumber, Street street, City city, PostCode postCode, String identifier, StoreStatus status) {
        this.id = id;
        this.name = name;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.identifier = identifier;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
