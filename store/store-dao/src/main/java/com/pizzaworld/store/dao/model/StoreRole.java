package com.pizzaworld.store.dao.model;

import com.pizzaworld.common.dao.model.AbstractAuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "store_role")
public class StoreRole extends AbstractAuditableEntity {
    @Column(nullable = false, length = 128)
    private String role;


    public StoreRole() {
    }

    public StoreRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StoreRole that = (StoreRole) o;

        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
