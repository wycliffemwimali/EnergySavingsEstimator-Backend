package com.example.reflectocalc.Repository;

import com.example.reflectocalc.model.EnergySavings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergySavingsRepository extends JpaRepository<EnergySavings, Long> {
}
