package com.pizzaworld.store.dao.model;

import com.pizzaworld.common.dao.model.AbstractAuditableEntity;
import com.pizzaworld.common.dao.model.DeliveryType;
import com.pizzaworld.common.dao.model.OrderStatus;
import com.pizzaworld.common.dao.model.OrderType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store_order")
public class StoreOrder extends AbstractAuditableEntity {

    @Column(nullable = false)
    private String orderNumber;
    @Column(nullable = false)
    private OrderType orderType;
    @Column(nullable = false)
    private DeliveryType deliveryType;
    @Column(nullable = false)
    private OrderStatus orderStatus;
    @Column(nullable = false)
    private Double totalAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryRoute", referencedColumnName = "id", nullable = false)
    private DeliveryRoute deliveryRoute;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storeOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<StoreOrderItem> storeOrderItems = new ArrayList<>();

    public StoreOrder() {
    }

    public StoreOrder(String orderNumber, OrderType orderType, DeliveryType deliveryType, OrderStatus orderStatus, Double totalAmount, DeliveryRoute deliveryRoute) {
        this.orderNumber = orderNumber;
        this.orderType = orderType;
        this.deliveryType = deliveryType;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.deliveryRoute = deliveryRoute;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public DeliveryRoute getDeliveryRoute() {
        return deliveryRoute;
    }

    public void setDeliveryRoute(DeliveryRoute deliveryRoute) {
        this.deliveryRoute = deliveryRoute;
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

        StoreOrder that = (StoreOrder) o;

        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (orderType != that.orderType) return false;
        if (deliveryType != that.deliveryType) return false;
        if (orderStatus != that.orderStatus) return false;
        if (totalAmount != null ? !totalAmount.equals(that.totalAmount) : that.totalAmount != null) return false;
        return deliveryRoute != null ? deliveryRoute.equals(that.deliveryRoute) : that.deliveryRoute == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);
        result = 31 * result + (deliveryType != null ? deliveryType.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (deliveryRoute != null ? deliveryRoute.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoreOrder{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderType=" + orderType +
                ", deliveryType=" + deliveryType +
                ", orderStatus=" + orderStatus +
                ", totalAmount=" + totalAmount +
                ", deliveryRoute=" + deliveryRoute +
                ", storeOrderItems=" + storeOrderItems +
                '}';
    }
}
