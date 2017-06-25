package com.pizzaworld.store.dao.model;

import com.pizzaworld.common.dao.model.DeliveryRouteStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery_route")
public class DeliveryRoute {

    @Column(nullable = false)
    private String deliveryRouteNumber;

    @Column(nullable = false)
    private Double gpsLatitude;

    @Column(nullable = false)
    private Double gpsLongitude;

    @Column(nullable = false)
    private DeliveryRouteStatus deliveryRouteStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryRoute", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<StoreOrder> storeOrders = new ArrayList<>();

    public DeliveryRoute() {

    }
    public DeliveryRoute(String deliveryRouteNumber, Double gpsLatitude, Double gpsLongitude, DeliveryRouteStatus deliveryRouteStatus) {
        this.deliveryRouteNumber = deliveryRouteNumber;
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitude = gpsLongitude;
        this.deliveryRouteStatus = deliveryRouteStatus;
    }

    public String getDeliveryRouteNumber() {
        return deliveryRouteNumber;
    }

    public void setDeliveryRouteNumber(String deliveryRouteNumber) {
        this.deliveryRouteNumber = deliveryRouteNumber;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public DeliveryRouteStatus getDeliveryRouteStatus() {
        return deliveryRouteStatus;
    }

    public void setDeliveryRouteStatus(DeliveryRouteStatus deliveryRouteStatus) {
        this.deliveryRouteStatus = deliveryRouteStatus;
    }

    public List<StoreOrder> getStoreOrders() {
        return storeOrders;
    }

    public void setStoreOrders(List<StoreOrder> storeOrders) {
        this.storeOrders = storeOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryRoute that = (DeliveryRoute) o;

        if (deliveryRouteNumber != null ? !deliveryRouteNumber.equals(that.deliveryRouteNumber) : that.deliveryRouteNumber != null)
            return false;
        if (gpsLatitude != null ? !gpsLatitude.equals(that.gpsLatitude) : that.gpsLatitude != null) return false;
        if (gpsLongitude != null ? !gpsLongitude.equals(that.gpsLongitude) : that.gpsLongitude != null) return false;
        return deliveryRouteStatus == that.deliveryRouteStatus;
    }

    @Override
    public int hashCode() {
        int result = deliveryRouteNumber != null ? deliveryRouteNumber.hashCode() : 0;
        result = 31 * result + (gpsLatitude != null ? gpsLatitude.hashCode() : 0);
        result = 31 * result + (gpsLongitude != null ? gpsLongitude.hashCode() : 0);
        result = 31 * result + (deliveryRouteStatus != null ? deliveryRouteStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeliveryRoute{" +
                "deliveryRouteNumber='" + deliveryRouteNumber + '\'' +
                ", gpsLatitude=" + gpsLatitude +
                ", gpsLongitude=" + gpsLongitude +
                ", deliveryRouteStatus=" + deliveryRouteStatus +
                ", storeOrders=" + storeOrders +
                '}';
    }
}
