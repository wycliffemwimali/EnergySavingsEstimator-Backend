package com.example.reflectocalc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyConsumption extends JpaRepository<EnergyConsumption, Long> {
    // Add custom query methods if needed
}
