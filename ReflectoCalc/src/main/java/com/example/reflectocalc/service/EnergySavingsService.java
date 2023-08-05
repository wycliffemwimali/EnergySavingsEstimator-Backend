package com.example.reflectocalc.service;

import com.example.reflectocalc.DTO.RooftopAreaDTO;

public interface EnergySavingsService {
    double CONSTANT_FACTOR = 0.5; // Define the constant factor for energy savings

    double calculateEnergySavings(RooftopAreaDTO rooftopAreaDTO);
}