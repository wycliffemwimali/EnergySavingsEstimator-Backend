package com.example.reflectocalc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Building extends JpaRepository<Building, Long> {
    // Add custom query methods if needed
}
