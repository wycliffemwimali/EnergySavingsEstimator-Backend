package com.example.reflectocalc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Roof extends JpaRepository<Roof, Long> {
    // Add custom query methods if needed
}
