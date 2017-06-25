package com.pizzaworld.store.dao.model;

import com.pizzaworld.common.dao.model.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store extends AbstractAuditableEntity {
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String streetNumber;
    @Column(nullable = false)
    private Street street;
    @Column(nullable = false)
    private City city;
    @Column(nullable = false)
    private PostCode postCode;
    @Column(length = 255, nullable = false)
    private String identifier;
    @Column(nullable = false)
    private StoreStatus status;

    public Store() {
    }

    public Store(String name, String streetNumber, Street street, City city, PostCode postCode, String identifier, StoreStatus status) {
        this.name = name;
        this.streetNumber =streetNumber;
        this.street = street;
        this.city = city;
        this.postCode=postCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Store that = (Store) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (streetNumber != null ? !streetNumber.equals(that.streetNumber) : that.streetNumber != null) return false;
        if (street != that.street) return false;
        if (city != that.city) return false;
        if (postCode != that.postCode) return false;
        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", street=" + street +
                ", city=" + city +
                ", postCode=" + postCode +
                ", identifier='" + identifier + '\'' +
                ", status=" + status +
                '}';
    }
}
