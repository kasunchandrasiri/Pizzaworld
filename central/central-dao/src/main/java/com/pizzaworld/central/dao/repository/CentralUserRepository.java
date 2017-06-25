package com.pizzaworld.central.dao.repository;

import com.pizzaworld.central.dao.model.CentralUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentralUserRepository extends JpaRepository<CentralUser,Long> {
    CentralUser findByUsername(String username);
}
