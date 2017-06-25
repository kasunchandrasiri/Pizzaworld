package com.pizzaworld.store.dao.model;

import com.pizzaworld.common.dao.model.AbstractAuditableEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "store_user")
public class StoreUser extends AbstractAuditableEntity{
    @Column(length = 255, nullable = false)
    private String username;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 1, nullable = false)
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id",referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id",referencedColumnName = "id",table = "role")})
    private List<StoreRole> storeRoleList = new ArrayList<>();

    public StoreUser() {
    }

    public StoreUser(String username, String password, Boolean enabled, List<StoreRole> storeRoleList) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.storeRoleList = storeRoleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<StoreRole> getStoreRoleList() {
        return storeRoleList;
    }

    public void setStoreRoleList(List<StoreRole> storeRoleList) {
        this.storeRoleList = storeRoleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StoreUser that = (StoreUser) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoreUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", storeRoleList=" + storeRoleList +
                '}';
    }
}
