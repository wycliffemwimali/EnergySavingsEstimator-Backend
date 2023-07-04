package com.example.reflectocalc.Repository;

import com.example.reflectocalc.model.Rooftop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RooftopRepository extends JpaRepository<Rooftop, Long> {
    // Custom query method to find rooftops by building ID
    List<Rooftop> findByBuildingId(Long buildingId);

    // Custom query method to find rooftops by reflectance
    List<Rooftop> findByReflectanceGreaterThan(double reflectance);
}
