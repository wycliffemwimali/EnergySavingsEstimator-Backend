package com.example.reflectocalc.Repository;

import com.example.reflectocalc.model.Roof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoofRepository extends JpaRepository<Roof, Long> {
    // Custom query method to find rooftops by building ID
    List<Roof> findByBuildingId(Long buildingId);

    // Custom query method to find rooftops by reflectance
//    List<Roof> findByReflectanceGreaterThan(double reflectance);
}
