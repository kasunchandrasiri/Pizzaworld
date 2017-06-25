package com.pizzaworld.store.dao.model;

import com.pizzaworld.common.dao.model.AbstractAuditableEntity;
import com.pizzaworld.common.dao.model.ProductType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store_product")
public class StoreProduct extends AbstractAuditableEntity {

    @Column(nullable = false)
    private String productNumber;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(length = 255)
    private String description;
    @Column(nullable = false)
    private ProductType productType;
    @Column(nullable = false)
    private float price;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storeProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<StoreOrderItem> storeOrderItems = new ArrayList<>();

    public StoreProduct() {
    }

    public StoreProduct(String productNumber, String name, String description, ProductType productType, float price, List<StoreOrderItem> storeOrderItems) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
        this.storeOrderItems = storeOrderItems;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<StoreOrderItem> getStoreOrderItems() {
        return storeOrderItems;
    }

    public void setStoreOrderItems(List<StoreOrderItem> storeOrderItems) {
        this.storeOrderItems = storeOrderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StoreProduct that = (StoreProduct) o;

        if (Float.compare(that.price, price) != 0) return false;
        if (productNumber != null ? !productNumber.equals(that.productNumber) : that.productNumber != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return productType == that.productType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (productNumber != null ? productNumber.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoreProduct{" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                '}';
    }
}