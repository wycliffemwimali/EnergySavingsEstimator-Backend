package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.BuildingRepository;
import com.example.reflectocalc.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuidingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public double calculateEnergySavingsByReflectance(Building building) {
        double reflectance = building.getRooftop().getReflectance();
        // Perform calculation logic here
        double energySavings = reflectance * 0.5;

        return energySavings;
    }

    // Add more methods as needed
}
