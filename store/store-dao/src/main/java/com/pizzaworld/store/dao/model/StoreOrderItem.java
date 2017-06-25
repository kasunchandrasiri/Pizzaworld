package com.pizzaworld.store.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "store_order_item")
public class StoreOrderItem {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeOrder", referencedColumnName = "id", nullable = false)
    private StoreOrder storeOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeProduct", referencedColumnName = "id", nullable = false)
    private StoreProduct storeProduct;
    @Column(nullable = false)
    private int quantity;

    public StoreOrderItem() {
    }

    public StoreOrderItem(StoreOrder storeOrder, StoreProduct storeProduct, int quantity) {
        this.storeOrder = storeOrder;
        this.storeProduct = storeProduct;
        this.quantity = quantity;
    }

    public StoreOrder getStoreOrder() {
        return storeOrder;
    }

    public void setStoreOrder(StoreOrder storeOrder) {
        this.storeOrder = storeOrder;
    }

    public StoreProduct getStoreProduct() {
        return storeProduct;
    }

    public void setStoreProduct(StoreProduct storeProduct) {
        this.storeProduct = storeProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreOrderItem that = (StoreOrderItem) o;

        if (quantity != that.quantity) return false;
        if (storeOrder != null ? !storeOrder.equals(that.storeOrder) : that.storeOrder != null) return false;
        return storeProduct != null ? storeProduct.equals(that.storeProduct) : that.storeProduct == null;
    }

    @Override
    public int hashCode() {
        int result = storeOrder != null ? storeOrder.hashCode() : 0;
        result = 31 * result + (storeProduct != null ? storeProduct.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "StoreOrderItem{" +
                "storeOrder=" + storeOrder +
                ", storeProduct=" + storeProduct +
                ", quantity=" + quantity +
                '}';
    }
}
