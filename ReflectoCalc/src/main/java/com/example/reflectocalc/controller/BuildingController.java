package com.example.reflectocalc.controller;

import com.example.reflectocalc.model.Building;
import com.example.reflectocalc.service.BuidingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    private final BuidingService buildingService;

    @Autowired
    public BuildingController(BuidingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {
        Building building = buildingService.getBuildingById(id);
        if (building != null) {
            return ResponseEntity.ok(building);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Building building) {
        Building createdBuilding = buildingService.createBuilding(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuilding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Building> updateBuilding(@PathVariable Long id, @RequestBody Building building) {
        Building updatedBuilding = buildingService.updateBuilding(id, building);
        if (updatedBuilding != null) {
            return ResponseEntity.ok(updatedBuilding);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        boolean deleted = buildingService.deleteBuilding(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/energy-savings")
    public ResponseEntity<Double> calculateEnergySavingsByReflectance(@PathVariable Long id) {
        Building building = buildingService.getBuildingById(id);
        if (building != null) {
            double energySavings = buildingService.calculateEnergySavingsByReflectance(building);
            return ResponseEntity.ok(energySavings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/cooling-load")
    public ResponseEntity<Double> calculateCoolingLoad(@PathVariable Long id) {
        Building building = buildingService.getBuildingById(id);
        if (building != null) {
            double coolingLoad = buildingService.calculateCoolingLoad(building);
            return ResponseEntity.ok(coolingLoad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/average-temperature")
    public ResponseEntity<Double> getAverageTemperature(@PathVariable Long id) {
        Building building = buildingService.getBuildingById(id);
        if (building != null) {
            double averageTemperature = buildingService.getAverageTemperature(building);
            return ResponseEntity.ok(averageTemperature);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more methods as needed
}
}
