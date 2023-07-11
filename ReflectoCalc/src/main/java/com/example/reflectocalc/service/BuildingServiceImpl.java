package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.BuildingRepository;
import com.example.reflectocalc.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    @Override
    public double calculateCoolingLoad(Building building) {
        double indoorTemperature = building.getIndoorTemperature();
        double outdoorTemperature = building.getOutdoorTemperature();
        double roofArea = building.getRooftop().getArea();

        // Calculation logic for cooling load
        double temperatureDifference = indoorTemperature - outdoorTemperature;
        double coolingLoad = temperatureDifference * roofArea * 0.1; // Example calculation, adjust according to your requirements

        return coolingLoad;
    }

    @Override
    public double getAverageTemperature(Building building) {
        // Retrieve temperature data and calculate average temperature
        List<Double> temperatureData = Collections.singletonList(building.getTemperatureData()); // Assuming temperatureData is a list of temperature values
        double sum = 0.0;
        for (Double temperature : temperatureData) {
            sum += temperature;
        }
        double averageTemperature = sum / temperatureData.size();

        return averageTemperature;
    }

    @Override
    public Building getBuildingById(Long id) {
        return buildingRepository.findById(id).orElse(null);
    }

    @Override
    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }


    // Add more methods as needed
}
