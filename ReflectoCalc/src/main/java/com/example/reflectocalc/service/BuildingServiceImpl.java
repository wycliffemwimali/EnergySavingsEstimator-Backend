package com.example.reflectocalc.service;

import com.example.reflectocalc.Repository.BuildingRepository;
import com.example.reflectocalc.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuidingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public double calculateEnergySavingsByReflectance(Building building) {
//        double reflectance = building.getRooftop().getReflectance();
        double rooftopArea = building.getRooftop().getArea();
        // Perform calculation logic here
        double energySavings = rooftopArea * 0.5;

        return energySavings;
    }

    @Override
    public double calculateCoolingLoad(Building building) {
        double indoorTemperature = building.getIndoorTemperature();
        double outdoorTemperature = building.getOutdoorTemperature();
        double roofArea = building.getRooftop().getArea();

        // Calculation logic for cooling load
        double temperatureDifference = indoorTemperature - outdoorTemperature;
        double coolingLoad = temperatureDifference * roofArea * 0.1;

        return coolingLoad;
    }

    @Override
    public double getAverageTemperature(Building building) {
        // Retrieve temperature data and calculate average temperature
        List<Double> temperatureData = Collections.singletonList(building.getTemperatureData()); 
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

    @Override
    public Building updateBuilding(Long id, Building building) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            Building existingBuilding = optionalBuilding.get();
            existingBuilding.setName(building.getName());
            existingBuilding.setAddress(building.getAddress());
            return buildingRepository.save(existingBuilding);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBuilding(Long id) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isPresent()) {
            buildingRepository.delete(optionalBuilding.get());
            return true;
        } else {
            return false;
        }
    }


}
