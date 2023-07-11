package com.example.reflectocalc.service;

import com.example.reflectocalc.model.Building;

public interface BuidingService {
    double calculateEnergySavingsByReflectance(Building building);
    double calculateCoolingLoad(Building building);
    double getAverageTemperature(Building building);

    Building getBuildingById(Long id);
}
