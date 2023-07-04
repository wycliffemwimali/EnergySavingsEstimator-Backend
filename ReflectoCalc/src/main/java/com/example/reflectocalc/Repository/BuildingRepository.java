package com.example.reflectocalc.Repository;

import com.example.reflectocalc.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    // Custom query method to find buildings by city
    List<Building> findByCity(String city);

    // Custom query method to find buildings by owner name
    List<Building> findByOwnerName(String ownerName);
}
