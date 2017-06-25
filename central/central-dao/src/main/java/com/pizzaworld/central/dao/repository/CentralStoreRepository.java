package com.pizzaworld.central.dao.repository;

import com.pizzaworld.central.dao.model.CentralStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentralStoreRepository extends JpaRepository<CentralStore,Long> {
    CentralStore findByIdentifier(String identifier);
}
