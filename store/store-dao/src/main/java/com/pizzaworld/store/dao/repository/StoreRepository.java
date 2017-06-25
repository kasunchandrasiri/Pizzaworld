package com.pizzaworld.store.dao.repository;


import com.pizzaworld.store.dao.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
