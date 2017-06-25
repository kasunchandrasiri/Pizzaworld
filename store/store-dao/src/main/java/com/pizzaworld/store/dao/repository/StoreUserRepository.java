package com.pizzaworld.store.dao.repository;

import com.pizzaworld.store.dao.model.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreUserRepository extends JpaRepository<StoreUser,Long> {
    StoreUser findByUsername(String username);
}
