package com.pizzaworld.central.dao.model;

import com.pizzaworld.common.dao.model.AbstractAuditableEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "central_user")
public class CentralUser extends AbstractAuditableEntity{
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
    private List<CentralRole> centralRoleList = new ArrayList<>();

    public CentralUser() {
    }

    public CentralUser(String username, String password, Boolean enabled, List<CentralRole> centralRoleList) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.centralRoleList = centralRoleList;
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

    public List<CentralRole> getCentralRoleList() {
        return centralRoleList;
    }

    public void setCentralRoleList(List<CentralRole> centralRoleList) {
        this.centralRoleList = centralRoleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CentralUser that = (CentralUser) o;

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
        return "CentralUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", centralRoleList=" + centralRoleList +
                '}';
    }
}
